package com.ecommercepractice.authentication.exceptions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AuthException extends RuntimeException {
    private Object payload;
    private ErrorType errorType;

    public AuthException(String msg, Object payload, ErrorType errorType){
        super(msg);
        this.payload = payload;
        this.errorType = errorType;
    }

}
