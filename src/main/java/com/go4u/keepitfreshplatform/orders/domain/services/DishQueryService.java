package com.go4u.keepitfreshplatform.orders.domain.services;

import com.go4u.keepitfreshplatform.orders.domain.model.aggregates.Dish;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetAllDishesQuery;
import com.go4u.keepitfreshplatform.orders.domain.model.queries.GetDishByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DishQueryService {

    Optional<Dish> handle(GetDishByIdQuery query);

    List<Dish> handle(GetAllDishesQuery query);


}
