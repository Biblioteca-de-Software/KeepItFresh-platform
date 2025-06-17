package com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Price(BigDecimal price) {
    public Price {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be a positive amount.");
        }
    }
}