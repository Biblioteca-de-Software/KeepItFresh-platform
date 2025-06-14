package com.go4u.keepitfreshplatform.inventory.domain.services;

import com.go4u.keepitfreshplatform.inventory.domain.model.aggregates.Product;
import com.go4u.keepitfreshplatform.inventory.domain.model.queries.GetAllProductsQuery;

import java.util.List;

public interface ProductQueryService {
    List<Product> handle(GetAllProductsQuery query);
}
