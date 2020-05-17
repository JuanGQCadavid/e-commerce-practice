package com.ecommercepractice.productservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * This error occur when a problem arise from
 * finding a product by its id inse the repository
 */
public class ProductNotFoundedException extends GeneralException {
    public ProductNotFoundedException(long productId){
        super(String.format("The product with id { %s } does not exist", productId),
                ErrorType.PRODUCT_NOT_FOUNDED.generateGeneral() ,productId);
    }
}
