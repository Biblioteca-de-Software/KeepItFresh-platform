package com.go4u.keepitfreshplatform.orders.application.internal.queryservices;

import com.go4u.keepitfreshplatform.orders.domain.model.aggregates.Order;
import com.go4u.keepitfreshplatform.orders.domain.model.entities.OrderItem;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetAllOrdersQuery;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetOrderByIdQuery;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetOrderItemByTableQuery;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetOrdersByTableNumberQuery;
import com.go4u.keepitfreshplatform.orders.domain.services.OrderQueryService;
import com.go4u.keepitfreshplatform.orders.infrastructure.persistence.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> handle(GetAllOrdersQuery query){
        return orderRepository.findAll();
    }

    @Override
    public List<OrderItem> handle(GetOrderItemByTableQuery query){
        return orderRepository.findByTableNumber(query.tableNumber()).map(order -> order.getOrderSummary().getOrderItems())
                .orElse(Collections.emptyList());
    }

    @Override
    public Optional<Order> handle(GetOrderByIdQuery query){
        return orderRepository.findById(query.orderId());
    }

    @Override
    public List<Order> handle(GetOrdersByTableNumberQuery query) {
        return orderRepository.findAllByTableNumber(query.tableNumber());
    }


}
