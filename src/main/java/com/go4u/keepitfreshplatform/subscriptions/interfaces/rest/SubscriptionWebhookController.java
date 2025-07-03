package com.go4u.keepitfreshplatform.subscriptions.interfaces.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.go4u.keepitfreshplatform.subscriptions.infrastructure.persistance.jpa.repositories.UserSubscriptionRepository;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/webhooks/stripe")
@RequiredArgsConstructor
@Tag(name = "Subscriptions Webhook", description = "Stripe subscription webhook handler")
public class SubscriptionWebhookController {

    private final UserSubscriptionRepository repository;
    private static final String endpointSecret = "whsec_e7cc77d51118f1204c24b3e3252361fdf9740cde2eddeffe2619b4401f5568c5";

    @PostMapping
    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload,
                                                      @RequestHeader("Stripe-Signature") String sigHeader) {
        Event event;
        try {
            event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
        } catch (SignatureVerificationException e) {
            System.out.println("Invalid signature: " + e.getMessage());
            return ResponseEntity.badRequest().body("Invalid webhook signature");
        }

        System.out.println("Webhook received: " + event.getType());

        if ("checkout.session.completed".equals(event.getType())) {
            try {
                // Parsear el payload manualmente con ObjectMapper
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(payload);
                String sessionId = root.path("data").path("object").path("id").asText();

                System.out.println("Recovering session from Stripe with ID: " + sessionId);

                // Recuperar sesión directamente desde Stripe
                Session session = Session.retrieve(sessionId);
                String email = session.getCustomerEmail();
                String subscriptionId = session.getSubscription();

                if (email != null) {
                    repository.findByEmailContainingIgnoreCase(email).forEach(subscription -> {
                        subscription.setStatus("active");
                        subscription.setStripeSubscriptionId(subscriptionId);
                        subscription.setStartDate(LocalDate.now());
                        subscription.setActive(true);
                        repository.save(subscription);
                        System.out.println("Subscription activated for: " + email);
                    });
                } else {
                    System.out.println("Email not found in the session.");
                }

            } catch (Exception e) {
                System.out.println("Error processing session: " + e.getMessage());
                return ResponseEntity.internalServerError().body("Error processing session");
            }
        }

        return ResponseEntity.ok("Webhook processed successfully");
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllSubscriptions() {
        repository.deleteAll();
        return ResponseEntity.ok("All subscriptions have been removed");
    }
}
