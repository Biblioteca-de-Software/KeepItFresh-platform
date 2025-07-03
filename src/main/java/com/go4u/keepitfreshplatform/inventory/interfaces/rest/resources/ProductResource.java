package com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductResource(
        Long productId,
        String name,
        BigDecimal price,
        int quantity,
        LocalDate expirationDate
) {}
