package com.go4u.keepitfreshplatform.subscriptions.interfaces.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Stripe checkout response")
public record CheckoutResponse(
        @Schema(example = "https://checkout.stripe.com/pay/cs_test_...")
        String checkoutUrl
) {}
