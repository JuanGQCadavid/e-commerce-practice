package com.ecommercepractice.productservice.exception;

import com.ecommercepractice.productservice.model.Product;
import lombok.Getter;

@Getter
public class ProductNotCreatedException extends RuntimeException {
    private Product payload;
    public ProductNotCreatedException(Product product){
        super(String.format("The where a problem at creating the product with payload { %s }", product));
        this.payload = product;
    }
}
