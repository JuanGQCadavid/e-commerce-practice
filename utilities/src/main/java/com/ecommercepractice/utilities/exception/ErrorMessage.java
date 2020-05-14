package com.ecommercepractice.utilities.exception;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Error class that represents the error itself
 * it contains the timeStamp, the message and a
 * payLoad that shows where the error is.
 *
 * Also, it has a variable that represents the internal
 * error for the user.
 */

@Getter
public class ErrorMessage {
    // Time when the error occurred (Server time)
    private LocalDateTime timeStamp;

    // Message explaining the error
    private String message;

    // Error type threw inside the server
    private String errorType;

    //Portion of the data that cause the error
    private Object payload;

    /**
     *Error representation.
     *
     * @param message -> Short description of the problem
     * @param generalErrorType -> Internal runtime exception flag.
     * @param payload -> Pointing to the data that cause the problem.
     */
    public ErrorMessage(String message, GeneralErrorType generalErrorType, Object payload){
        this.message = message;
        this.errorType = generalErrorType.getLabel();
        this.payload = payload;
        this.timeStamp = LocalDateTime.now();
    }

    public ErrorMessage(GeneralException ex){
        this.message = ex.getMessage();
        this.errorType = ex.getGeneralErrorType().getLabel();
        this.payload = ex.getPayload();
        this.timeStamp = LocalDateTime.now();
    }
}