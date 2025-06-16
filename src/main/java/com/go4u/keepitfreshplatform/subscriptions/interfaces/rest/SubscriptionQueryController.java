package com.go4u.keepitfreshplatform.subscriptions.interfaces.rest;

import com.go4u.keepitfreshplatform.subscriptions.domain.model.entities.UserSubscription;
import com.go4u.keepitfreshplatform.subscriptions.infrastructure.persistance.jpa.repositories.UserSubscriptionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
@Tag(name = "Subscriptions", description = "Query user subscriptions")
public class SubscriptionQueryController {

    private final UserSubscriptionRepository repository;

    @GetMapping
    @Operation(summary = "Get all subscriptions")
    public List<UserSubscription> getAllSubscriptions() {
        return repository.findAll();
    }
}
