package com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateProductResource(
        @NotBlank(message = "Name is required") String name,
        @NotNull(message = "Quantity is required")
        @Positive(message = "Quantity must be a positive number") Integer quantity,
        @NotNull(message = "Expiration date is required") LocalDate expirationDate,
        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.01", message = "Price must be positive") BigDecimal price
) {}