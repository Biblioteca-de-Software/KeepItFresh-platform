package com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Quantity(Integer quantity) {
    public Quantity {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
    }
}

