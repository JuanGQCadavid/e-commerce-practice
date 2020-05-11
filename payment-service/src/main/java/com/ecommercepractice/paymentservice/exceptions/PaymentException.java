package com.ecommercepractice.paymentservice.exceptions;

import lombok.Getter;

@Getter
public class PaymentException extends RuntimeException {
    private ErrorType errorType;
    private Object payload;

    public PaymentException(String msg, ErrorType errorType, Object payload){
        super(msg);
        this.errorType = errorType;
        this.payload = payload;
    }

}
