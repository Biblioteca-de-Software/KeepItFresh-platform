package com.go4u.keepitfreshplatform.inventory.domain.services;

import com.go4u.keepitfreshplatform.inventory.domain.model.commands.CreateProductCommand;

public interface ProductCommandService {

    Long handle(CreateProductCommand command);

}
