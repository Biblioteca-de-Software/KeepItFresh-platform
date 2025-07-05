package com.go4u.keepitfreshplatform.inventory.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.inventory.domain.model.aggregates.Product;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources.ProductItemResource;

public class ProductItemResourceFromEntityAssembler {
    public static ProductItemResource toResourceFromEntity(Product entity){
        return new ProductItemResource(
                entity.getProductId(),
                entity.getName(),                    // ✅ AGREGADO
                entity.getQuantity(),
                entity.getExpirationDate(),
                entity.getPrice()
        );
    }
}
