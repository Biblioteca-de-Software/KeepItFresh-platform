package com.go4u.keepitfreshplatform.inventory.interfaces.rest;

import com.go4u.keepitfreshplatform.inventory.domain.model.queries.GetAllProductsQuery;
import com.go4u.keepitfreshplatform.inventory.domain.model.queries.GetProductByIdQuery;
import com.go4u.keepitfreshplatform.inventory.domain.services.ProductCommandService;
import com.go4u.keepitfreshplatform.inventory.domain.services.ProductQueryService;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources.CreateProductResource;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.resources.ProductResource;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.go4u.keepitfreshplatform.inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/products", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "Operations related to products in the inventory")
public class ProductsController {

    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductsController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource createProductResource) {

        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(createProductResource);
        var productId = productCommandService.handle(createProductCommand);
        if (productId == null) {
            return ResponseEntity.badRequest().build();
        }

        var getProductQuery = new GetProductByIdQuery(productId);
        var optionalProduct = productQueryService.handle(getProductQuery);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(optionalProduct.get());
        return ResponseEntity.ok(productResource);
    }

    @GetMapping
    public ResponseEntity<List<ProductResource>> getAllProducts() {
        var getAllProductsQuery = new GetAllProductsQuery();
        var products = productQueryService.handle(getAllProductsQuery);
        var productResources = products.stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(productResources);
    }
}
