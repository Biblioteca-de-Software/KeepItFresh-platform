package com.go4u.keepitfreshplatform.orders.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Price(BigDecimal price) {

    public Price{
        if(price==null|| price.equals(BigDecimal.ZERO)){
            throw new IllegalArgumentException("Price must not be null or zero");
        }
    }
}
