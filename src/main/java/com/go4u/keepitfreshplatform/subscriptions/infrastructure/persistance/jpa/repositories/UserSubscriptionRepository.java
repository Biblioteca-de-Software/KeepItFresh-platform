package com.go4u.keepitfreshplatform.subscriptions.infrastructure.persistance.jpa.repositories;

import com.go4u.keepitfreshplatform.subscriptions.domain.model.entities.UserSubscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    Optional<UserSubscription> findByEmail(String email);
    List<UserSubscription> findByEmailContainingIgnoreCase(String email);
    List<UserSubscription> findByStatus(String status);
    List<UserSubscription> findByEmailAndStatus(String email, String status);
    Page<UserSubscription> findAll(Pageable pageable);
    boolean existsByEmailIgnoreCaseAndActiveTrue(String email);
}
