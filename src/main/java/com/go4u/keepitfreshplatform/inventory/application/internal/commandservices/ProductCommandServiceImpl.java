package com.go4u.keepitfreshplatform.inventory.application.internal.commandservices;

import com.go4u.keepitfreshplatform.inventory.domain.model.aggregates.Product;
import com.go4u.keepitfreshplatform.inventory.domain.model.commands.CreateProductCommand;
import com.go4u.keepitfreshplatform.inventory.domain.services.ProductCommandService;
import com.go4u.keepitfreshplatform.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {
        var product = new Product(command);

        try{
            productRepository.save(product);
        }catch (Exception e){
            throw new IllegalArgumentException
                    ("Error while saving product"
                            + e.getMessage());
        }
        return product.getId();
    }
}
