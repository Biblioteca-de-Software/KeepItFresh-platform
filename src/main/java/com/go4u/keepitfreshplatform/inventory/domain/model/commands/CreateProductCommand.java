package com.go4u.keepitfreshplatform.inventory.domain.model.commands;

import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.ExpirationDate;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Price;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Quantity;

public record CreateProductCommand(Long productId,
                                   String name,
                                   Price price,
                                   Quantity quantity,
                                   ExpirationDate expirationDate) {
}
