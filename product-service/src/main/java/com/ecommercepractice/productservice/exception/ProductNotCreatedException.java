package com.ecommercepractice.productservice.exception;

import com.ecommercepractice.productservice.model.Product;


public class ProductNotCreatedException extends ProductException{
    public ProductNotCreatedException(Product product){
        super(String.format("The where a problem at creating the product with payload { %s }", product),
                product,
                ErrorType.PRODUCT_NOT_CREATED);
    }
}
