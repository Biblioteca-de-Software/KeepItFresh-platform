package com.go4u.keepitfreshplatform.subscriptions.interfaces.rest;

import com.go4u.keepitfreshplatform.subscriptions.domain.model.entities.UserSubscription;
import com.go4u.keepitfreshplatform.subscriptions.infrastructure.persistance.jpa.repositories.UserSubscriptionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
@Tag(name = "Subscriptions", description = "Consulta de subscripciones de usuarios")
public class SubscriptionQueryController {

    private final UserSubscriptionRepository repository;

    @GetMapping
    @Operation(summary = "Obtener todas las suscripciones")
    public List<UserSubscription> getAllSubscriptions() {
        return repository.findAll();
    }
}
