package com.ecommercepractice.utilities.exception;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {
    private ErrorType errorType;
    private Object Payload;

    public GeneralException(String msg,ErrorType errorType, Object Payload){
        super(msg);
        this.errorType = errorType;
        this.Payload = Payload;
    }
}
