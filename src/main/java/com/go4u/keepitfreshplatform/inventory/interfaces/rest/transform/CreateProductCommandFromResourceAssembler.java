package com.go4u.keepitfreshplatform.inventory.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.inventory.domain.model.commands.CreateProductCommand;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource){
        return new CreateProductCommand(resource.productItemId());
    }
}
