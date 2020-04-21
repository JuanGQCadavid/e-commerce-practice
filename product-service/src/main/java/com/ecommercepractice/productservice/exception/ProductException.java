package com.ecommercepractice.productservice.exception;

import lombok.Getter;

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
