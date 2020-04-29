package com.ecommercepractice.productservice.exception;

import com.ecommercepractice.productservice.model.Product;

/**
 * This error occur when a problem arise from
 * creating phase onto the repository
 */
public class ProductNotCreatedException extends ProductException{
    public ProductNotCreatedException(Product product){
        super(String.format("The where a problem at creating the product with payload { %s }", product), product,ErrorType.PRODUCT_NOT_CREATED);
    }
}
