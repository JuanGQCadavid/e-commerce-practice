package com.ecommercepractice.paymentservice.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * it contains the timeStamp, the message and a
 * payLoad that shows where the error is.
 *
 * Also, it has a variable that represents the internal
 * error for the user.
 */

@Data
public class ErrorMessage {
    private LocalDateTime timeStamp;

    private String message;

    private String errorType;

    private Object payload;

    /**
     *Error representation.
     *
     * @param message -> Short description of the problem
     * @param errorType -> Internal runtime exception flag.
     * @param payload -> Pointing to the data that cause the problem.
     */
    public ErrorMessage(String message,ErrorType errorType, Object payload){
        this.message = message;
        this.errorType = errorType.getLabel();
        this.payload = payload;
        this.timeStamp = LocalDateTime.now();
    }

    public ErrorMessage(PaymentException ex){
        this.message = ex.getMessage();
        this.errorType = ex.getErrorType().getLabel();
        this.payload = ex.getPayload();
        this.timeStamp = LocalDateTime.now();
    }
}