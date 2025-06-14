package com.go4u.keepitfreshplatform.inventory.application.internal.queryservices;

import com.go4u.keepitfreshplatform.inventory.domain.model.aggregates.Product;
import com.go4u.keepitfreshplatform.inventory.domain.model.queries.GetAllProductsQuery;
import com.go4u.keepitfreshplatform.inventory.domain.services.ProductQueryService;
import com.go4u.keepitfreshplatform.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;

import java.util.List;

public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> handle(GetAllProductsQuery query) {
        return productRepository.findAll();
    }
}
