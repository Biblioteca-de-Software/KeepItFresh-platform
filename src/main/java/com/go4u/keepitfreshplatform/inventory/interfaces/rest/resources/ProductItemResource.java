package com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources;

import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.ExpirationDate;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Price;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Quantity;

public record ProductItemResource(
        Long productItemId,
        String name,                          // ✅ AGREGADO
        Quantity quantity,
        ExpirationDate expirationDate,
        Price price
) {}
