package com.ecommercepractice.utilities.exception;

import lombok.Builder;
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
@Builder
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

}