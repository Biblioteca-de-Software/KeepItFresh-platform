package com.go4u.keepitfreshplatform.orders.domain.model.aggregates;

import com.go4u.keepitfreshplatform.orders.domain.model.valueobjects.Price;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Embedded
    private Price price;

}
