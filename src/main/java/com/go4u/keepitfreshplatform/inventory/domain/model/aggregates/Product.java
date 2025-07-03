package com.go4u.keepitfreshplatform.inventory.domain.model.aggregates;

import com.go4u.keepitfreshplatform.inventory.domain.model.commands.CreateProductCommand;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.ExpirationDate;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Price;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.ProductId;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Quantity;
import com.go4u.keepitfreshplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
public class Product extends AuditableAbstractAggregateRoot<Product> {

    private String name;

    @Embedded
    private ProductId productId;

    @Embedded
    private Quantity quantity;

    @Embedded
    private ExpirationDate expirationDate;

    @Embedded
    private Price price;

    public Product() {
        this.name = Strings.EMPTY;
    }


    public Product(CreateProductCommand command) {
        this.name = command.name();
        //this.productId = new ProductId(command.productId());
        this.quantity = new Quantity(command.quantity());
        this.expirationDate = new ExpirationDate(command.expirationDate());
        this.price = new Price(command.price());
    }
}
