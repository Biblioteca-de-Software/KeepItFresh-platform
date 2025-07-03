package com.go4u.keepitfreshplatform.inventory.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.inventory.domain.model.aggregates.Product;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product product) {
        return new ProductResource(
                product.getId(),
                product.getName(),
                product.getPrice().price(),
                product.getQuantity().quantity(),
                product.getExpirationDate().expirationDate()
        );
    }
}
