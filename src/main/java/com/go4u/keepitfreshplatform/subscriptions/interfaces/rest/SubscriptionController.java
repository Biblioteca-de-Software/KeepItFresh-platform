package com.go4u.keepitfreshplatform.subscriptions.interfaces.rest;

import com.go4u.keepitfreshplatform.subscriptions.application.internal.commandServices.CreateSubscriptionService;
import com.go4u.keepitfreshplatform.subscriptions.interfaces.rest.dto.CheckoutResponse;
import com.go4u.keepitfreshplatform.subscriptions.interfaces.rest.dto.SubscriptionRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
@CrossOrigin
@Tag(name = "Subscriptions", description = "Stripe subscription checkout")
public class SubscriptionController {

    private final CreateSubscriptionService createSubscriptionService;

    public SubscriptionController(CreateSubscriptionService createSubscriptionService) {
        this.createSubscriptionService = createSubscriptionService;
    }

    @PostMapping
    @Operation(summary = "Create Stripe checkout session")
    public ResponseEntity<CheckoutResponse> createSubscription(@RequestBody SubscriptionRequest request) {
        try {
            String checkoutUrl = createSubscriptionService.createCheckoutSession(
                    request.userEmail, request.plan
            );
            return ResponseEntity.ok(new CheckoutResponse(checkoutUrl));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new CheckoutResponse("ERROR " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new CheckoutResponse("ERROR: " + e.getMessage()));
        }
    }
}
