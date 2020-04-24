package com.ecommercepractice.productservice.controller;
import com.ecommercepractice.productservice.model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler {
    /**
     * Creates links to methods that user could use
     * after the calling of a created nor fetch function
     * @param productCreated
     * @return
     */
    public EntityModel<Product> toModel(Product productCreated){
        return new EntityModel<>(productCreated,
                linkTo(methodOn(ProductController.class).fetchProductById(productCreated.getIdProduct())).withRel("FETCH"),
                linkTo(methodOn(ProductController.class).deleteProductById(productCreated.getIdProduct())).withRel("DELETE"),
                linkTo(methodOn(ProductController.class).updateProductById(productCreated.getIdProduct(),productCreated)).withRel("UPDATE")
                );
    }

}
