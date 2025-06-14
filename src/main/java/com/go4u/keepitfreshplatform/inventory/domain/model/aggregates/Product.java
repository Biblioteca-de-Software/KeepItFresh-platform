package com.go4u.keepitfreshplatform.inventory.domain.model.aggregates;

import com.go4u.keepitfreshplatform.inventory.domain.model.commands.CreateProductCommand;
import com.go4u.keepitfreshplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Product extends AuditableAbstractAggregateRoot<Product> {

    private String name;

    public Product() {
        this.name = Strings.EMPTY;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(CreateProductCommand command) {
        this.name = command.name();
    }



}
