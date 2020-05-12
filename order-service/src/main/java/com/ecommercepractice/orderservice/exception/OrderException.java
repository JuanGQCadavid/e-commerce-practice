package com.ecommercepractice.orderservice.exception;

import lombok.Getter;

@Getter
public class OrderException extends RuntimeException {
    private ErrorType errorType;
    private Object Payload;

    public OrderException(String msg, ErrorType errorType, Object Payload){
        super(msg);
        this.errorType = errorType;
        this.Payload = Payload;
    }
}
