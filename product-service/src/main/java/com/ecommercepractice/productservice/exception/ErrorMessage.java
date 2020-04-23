package com.ecommercepractice.productservice.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.SwaggerDefinition;
import lombok.Getter;

import javax.persistence.Entity;
import java.time.LocalDateTime;
/**
 * Error class that represents the error itself
 * it contains the timeStamp, the message and a
 * payLoad that shows where the error is.
 *
 * Also, it has a variable that represents the internal
 * error for the user.
 */
@ApiModel(value = "ErrorMessage",description = "When a error happen, the server response with" +
        " a ErrorMessage Entity")
@Getter
public class ErrorMessage {
    @ApiModelProperty("Time when the error occurred (Server time)")
    private LocalDateTime timeStamp;

    @ApiModelProperty("Message explaining the error")
    private String message;

    @ApiModelProperty("Error type threw inside the server")
    private String errorType;

    @ApiModelProperty("Portion of the data that cause the error")
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
        this. timeStamp = LocalDateTime.now();
    }
}