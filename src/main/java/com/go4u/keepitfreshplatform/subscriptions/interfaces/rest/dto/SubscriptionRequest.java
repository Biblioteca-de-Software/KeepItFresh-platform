package com.go4u.keepitfreshplatform.subscriptions.interfaces.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Subscription creation request")
public class SubscriptionRequest {

    @Schema(example = "marcoanakasone@gmail.com")
    public String userEmail;

    @Schema(example = "PRO", description = "Plan: STARTER, PRO, PRO_ANNUAL")
    public String plan;
}
