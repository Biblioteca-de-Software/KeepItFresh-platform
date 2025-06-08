package com.go4u.keepitfreshplatform.orders.domain.services;

import com.go4u.keepitfreshplatform.orders.domain.model.aggregates.Order;
import com.go4u.keepitfreshplatform.orders.domain.model.entities.OrderItem;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetAllOrdersQuery;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetOrderByIdQuery;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetOrderItemByTableQuery;

import java.util.List;
import java.util.Optional;

public interface OrderQueryService {

    List<Order> handle(GetAllOrdersQuery query);

    Optional<OrderItem> handle(GetOrderItemByTableQuery query);

    Optional<Order> handle(GetOrderByIdQuery query);

}
