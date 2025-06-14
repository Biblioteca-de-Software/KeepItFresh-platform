package com.go4u.keepitfreshplatform.inventory.infrastructure.persistence.jpa.repositories;

import com.go4u.keepitfreshplatform.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional query methods can be defined here if needed
}
