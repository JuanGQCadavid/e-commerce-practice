package com.fakeservers.cardFake.exceptions;

import lombok.Getter;

@Getter
public class CardException extends RuntimeException{
    private ErrorType errorType;
    public CardException(String msg, ErrorType errorType){
        super(msg);
        this.errorType = errorType;
    }
}
