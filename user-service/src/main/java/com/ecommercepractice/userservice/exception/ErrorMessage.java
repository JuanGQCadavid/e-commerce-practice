package com.ecommercepractice.userservice.exception;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Error class that represents the error itself
 * it contains the timeStamp, the message and a
 * payLoad that shows where the error is.
 */
@Getter
@AllArgsConstructor
public class ErrorMessage {
    private LocalDateTime timeStamp;
    private String message;
    private Object payload;

    /**
     * Default constructor, when it is created the object assign
     * the time stamp
     * @param message -> Show description of the problem
     * @param payload -> Indicates where the error was.
     */
    public ErrorMessage(String message, Object payload){
        this.message = message;
        this.payload = payload;
        this.timeStamp = LocalDateTime.now();
    }
}
