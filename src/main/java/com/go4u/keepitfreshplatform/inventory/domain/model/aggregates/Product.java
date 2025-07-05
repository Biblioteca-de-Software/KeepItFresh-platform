package com.go4u.keepitfreshplatform.inventory.domain.model.aggregates;

import com.go4u.keepitfreshplatform.inventory.domain.model.commands.CreateProductCommand;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.ExpirationDate;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Price;
import com.go4u.keepitfreshplatform.inventory.domain.model.valueobjects.Quantity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Entity
@Getter
public class Product{

    private String name;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long productId;

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
        this.quantity = new Quantity(command.quantity());
        this.expirationDate = new ExpirationDate(command.expirationDate());
        this.price = new Price(command.price());
    }
}
