package com.ecommercepractice.stockservice.exception;

import lombok.Getter;

/**
 * This class denotes a Stock errors family
 * when all subclasses must indicate its payload,
 * its internal error name and its user-friendly msg
 */

@Getter
public class StockException extends RuntimeException {
    private Object payload;
    private ErrorType errorType;

    public StockException(String msg,Object payload, ErrorType errorType){
        super(msg);
        this.payload = payload;
        this.errorType = errorType;
    }
}