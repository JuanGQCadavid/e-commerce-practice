package com.ecommercepractice.productservice.controller;


import com.ecommercepractice.productservice.model.Product;
import org.hibernate.EntityMode;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler {

    public EntityModel<Product> toModel(Product productCreated){
        return new EntityModel<>(productCreated,
                linkTo(methodOn(ProductController.class)
                        .fetchProductById(productCreated.getIdProduct())).withRel("FETCH"),
                linkTo(methodOn(ProductController.class)
                        .deleteProductById(productCreated.getIdProduct())).withRel("DELETE"),
                linkTo(methodOn(ProductController.class).updateProductById(
                        productCreated.getIdProduct(),
                        productCreated)).withRel("UPDATE")
                );
    }

}
