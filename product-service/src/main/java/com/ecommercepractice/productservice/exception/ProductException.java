package com.ecommercepractice.productservice.exception;

import lombok.Getter;

/**
 * This class denotes a product errors family
 * when all subclasses must indicate its payload,
 * its internal error name and a user-friendly msg
 */

@Getter
public class ProductException  extends RuntimeException{
    private Object payload;
    private ErrorType errorType;

    public ProductException(String msg, Object payload, ErrorType errorType){
        super(msg);
        this.payload = payload;
        this.errorType = errorType;
    }
}
