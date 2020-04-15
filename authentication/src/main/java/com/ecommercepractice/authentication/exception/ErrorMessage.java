package com.ecommercepractice.authentication.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorMessage {
    private LocalDateTime timeStamp;
    private String message;
    private String errorType;
    private Object payload;

    public ErrorMessage(String message,String errorType, Object payload){
        this.message = message;
        this.errorType = errorType;
        this.payload = payload;
        this. timeStamp = LocalDateTime.now();
    }



}
