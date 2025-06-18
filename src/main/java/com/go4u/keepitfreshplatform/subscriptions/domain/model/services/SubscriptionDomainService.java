package com.go4u.keepitfreshplatform.subscriptions.domain.model.services;

import com.go4u.keepitfreshplatform.subscriptions.domain.model.entities.UserSubscription;
import com.go4u.keepitfreshplatform.subscriptions.infrastructure.persistance.jpa.repositories.UserSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubscriptionDomainService {

    private final UserSubscriptionRepository repository;

    public boolean isAlreadySubscribed(String email) {
        return repository.existsByEmailIgnoreCaseAndActiveTrue(email);
    }

    public UserSubscription savePending(String email, String plan) {
        var subscription = UserSubscription.builder()
                .email(email)
                .plan(plan)
                .status("pending")
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(subscription);
    }
}