package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.authentication.exceptions.ErrorType;
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
    public ErrorMessage(String message, ErrorType errorType, Object payload){
        this.message = message;
        this.errorType = errorType.getLabel();
        this.payload = payload;
        this.timeStamp = LocalDateTime.now();
    }
}
