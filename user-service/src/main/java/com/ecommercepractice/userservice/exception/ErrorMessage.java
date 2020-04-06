package com.ecommercepractice.userservice.exception;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private LocalDateTime timeStamp;
    private String message;
    private Object payload;

    public ErrorMessage(String message, Object payload){
        this.message = message;
        this.payload = payload;
        this.timeStamp = LocalDateTime.now();
    }
}
