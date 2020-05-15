package com.fakeservers.cardFake.exceptions;

import lombok.Getter;

@Getter
public class CardException extends RuntimeException{
    private Object payload;
    private ErrorType errorType;
    public CardException(String msg, Object payload, ErrorType errorType){
        super(msg);
        this.payload = payload;
        this.errorType = errorType;
    }
}
