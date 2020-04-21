package com.ecommercepractice.productservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ProductNotFoundedException extends RuntimeException{
    private long payload;
    public ProductNotFoundedException(long productId){
        super(String.format("The product with id { %s } does not exist", productId));
        this.payload = productId;
    }
}
