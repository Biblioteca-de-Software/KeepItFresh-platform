package com.go4u.keepitfreshplatform.orders.domain.model.aggregates;


import com.go4u.keepitfreshplatform.orders.domain.model.valueobjects.Price;
import com.go4u.keepitfreshplatform.orders.domain.model.valueobjects.Table;
import com.go4u.keepitfreshplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.go4u.keepitfreshplatform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Order extends AuditableAbstractAggregateRoot<Order> {

    @NotNull
    private Long restaurantId;

    @NotNull
    private Table tableNumber;

    @NotNull
    private Price total;

    public Order(Long restaurantId, Table tableNumber, Price total) {
        this.restaurantId = restaurantId;
        this.tableNumber = tableNumber;
        this.total = total;
    }

    public Order() {
    }
}
