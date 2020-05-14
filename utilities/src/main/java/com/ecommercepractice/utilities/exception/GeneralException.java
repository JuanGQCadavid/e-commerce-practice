package com.ecommercepractice.utilities.exception;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {
    private GeneralErrorType generalErrorType;
    private Object Payload;

    public GeneralException(String msg,GeneralErrorType generalErrorType, Object Payload){
        super(msg);
        this.generalErrorType = generalErrorType;
        this.Payload = Payload;
    }
}
