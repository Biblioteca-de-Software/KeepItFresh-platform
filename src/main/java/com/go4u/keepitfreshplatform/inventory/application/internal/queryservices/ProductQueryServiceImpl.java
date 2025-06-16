package com.go4u.keepitfreshplatform.inventory.application.internal.queryservices;

import com.go4u.keepitfreshplatform.inventory.domain.model.aggregates.Product;
import com.go4u.keepitfreshplatform.inventory.domain.model.queries.GetAllProductsQuery;
import com.go4u.keepitfreshplatform.inventory.domain.model.queries.GetProductByIdQuery;
import com.go4u.keepitfreshplatform.inventory.domain.services.ProductQueryService;
import com.go4u.keepitfreshplatform.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> handle(GetAllProductsQuery query) {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }
}
