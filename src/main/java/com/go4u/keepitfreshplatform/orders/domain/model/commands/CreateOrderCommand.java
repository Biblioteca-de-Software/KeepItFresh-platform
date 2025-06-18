package com.go4u.keepitfreshplatform.orders.domain.model.commands;

public record CreateOrderCommand(Long restaurantId, int tableNumber) {
}
