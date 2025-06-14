package com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateProductResource(
        String name,
        Long productItemId,
        Integer quantity,
        LocalDate expirationDate,
        BigDecimal price
) {}