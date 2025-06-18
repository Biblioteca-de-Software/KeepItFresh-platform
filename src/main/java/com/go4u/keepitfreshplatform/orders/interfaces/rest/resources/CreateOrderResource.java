package com.go4u.keepitfreshplatform.orders.interfaces.rest.resources;


public record CreateOrderResource(Long restaurantId, Long orderItemId, int tableNumber) {
}
