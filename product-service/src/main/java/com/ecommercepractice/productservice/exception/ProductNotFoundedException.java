package com.ecommercepractice.productservice.exception;

import lombok.Getter;

public class ProductNotFoundedException extends ProductException{
    public ProductNotFoundedException(long productId){
        super(String.format("The product with id { %s } does not exist", productId),
                productId,
                ErrorType.PRODUCT_NOT_FOUNDED);
    }
}
