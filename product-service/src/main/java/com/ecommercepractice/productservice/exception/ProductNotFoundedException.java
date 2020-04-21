package com.ecommercepractice.productservice.exception;

/**
 * This error occur when a problem arise from
 * finding a product by its id inse the repository
 */
public class ProductNotFoundedException extends ProductException{
    public ProductNotFoundedException(long productId){
        super(String.format("The product with id { %s } does not exist", productId),
                productId,
                ErrorType.PRODUCT_NOT_FOUNDED);
    }
}
