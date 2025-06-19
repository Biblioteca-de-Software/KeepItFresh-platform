package com.go4u.keepitfreshplatform.orders.infrastructure.persistence.jpa.repositories;

import com.go4u.keepitfreshplatform.orders.domain.model.aggregates.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    //Optional<Dish> findByTable(Table table);

    //boolean existsByTable(Table table);

    boolean existsByName(String name);

}
