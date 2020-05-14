package com.ecommercepractice.carservice.exception;

/**
 * Standard cart Exception.
 */
public class CartException extends RuntimeException {
    ErrorType errorType;
    Object payload;

    /**
     * Cart Exception constructor.
     * @param msg -> error msg
     * @param payload -> Where the problem occurs
     * @param errorType -> Internal error type.
     */
    public CartException(String msg, Object payload, ErrorType errorType){
        super(msg);
        this.payload = payload;
        this.errorType = errorType;
    }
}
