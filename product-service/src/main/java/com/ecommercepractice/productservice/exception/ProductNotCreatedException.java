package com.ecommercepractice.productservice.exception;

import com.ecommercepractice.productservice.model.Product;
import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * This error occur when a problem arise from
 * creating phase onto the repository
 */
public class ProductNotCreatedException extends GeneralException {
    public ProductNotCreatedException(Product product){
        super(String.format("The where a problem at creating the product with payload { %s }", product),
                ErrorType.PRODUCT_NOT_CREATED.generateGeneral(), product);
    }
}
