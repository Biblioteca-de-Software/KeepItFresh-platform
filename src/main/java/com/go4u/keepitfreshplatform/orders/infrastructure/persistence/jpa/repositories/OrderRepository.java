package com.go4u.keepitfreshplatform.orders.infrastructure.persistence.jpa.repositories;

import com.go4u.keepitfreshplatform.orders.domain.model.aggregates.Dish;
import com.go4u.keepitfreshplatform.orders.domain.model.aggregates.Order;
import com.go4u.keepitfreshplatform.orders.domain.model.valueobjects.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderById(Long id);

    Optional<Order> findByTableNumber(int tableNumber);

    List<Order> findAllByTableNumber(int tableNumber);


}
