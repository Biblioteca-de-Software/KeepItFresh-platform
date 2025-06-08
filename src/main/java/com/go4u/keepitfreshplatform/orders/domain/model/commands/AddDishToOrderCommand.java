package com.go4u.keepitfreshplatform.orders.domain.model.commands;

import com.go4u.keepitfreshplatform.orders.domain.model.valueobjects.Quantity;

import java.math.BigDecimal;

public record AddDishToOrderCommand(Long orderId, Long dishId, Quantity quantity) {
}
