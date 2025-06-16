package com.go4u.keepitfreshplatform.subscriptions.application.internal.commandServices;

import com.go4u.keepitfreshplatform.subscriptions.domain.model.services.SubscriptionDomainService;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreateSubscriptionService {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    private final SubscriptionDomainService domainService;

    public CreateSubscriptionService(SubscriptionDomainService domainService) {
        this.domainService = domainService;
    }

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }

    public String createCheckoutSession(String email, String plan) throws Exception {
        if (domainService.isAlreadySubscribed(email)) {
            throw new IllegalArgumentException("User already subscribed: " + email);
        }

        Map<String, String> planPriceMap = Map.of(
                "STARTER", "price_1RaIqN05hYKLUN6NeqRA8buh",
                "PRO", "price_1RaIqq05hYKLUN6NhRvoVUSv",
                "PRO_ANNUAL", "price_1RaIrf05hYKLUN6NeL9iEXCt"
        );

        String priceId = planPriceMap.get(plan.toUpperCase());
        if (priceId == null) throw new IllegalArgumentException("Invalid plan: " + plan);

        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .setSuccessUrl("http://localhost:4200/pages/subscription/success")
                .setCancelUrl("http://localhost:4200/subscription/cancel")
                .setCustomerEmail(email)
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setPrice(priceId)
                        .setQuantity(1L)
                        .build())
                .build();

        Session session = Session.create(params);

        domainService.savePending(email, plan);

        return session.getUrl();
    }
}
