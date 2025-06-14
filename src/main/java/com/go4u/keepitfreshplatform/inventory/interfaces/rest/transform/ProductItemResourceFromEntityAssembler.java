package com.go4u.keepitfreshplatform.inventory.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.inventory.domain.model.entities.ProductItem;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources.ProductItemResource;

public class ProductItemResourceFromEntityAssembler {
    public static ProductItemResource toResourceFromEntity(ProductItem entity){
        return new ProductItemResource(
                entity.getId(),
                entity.getProduct().getId(),
                entity.getQuantity(),
                entity.getExpirationDate(),
                entity.getPrice());
    }
}
