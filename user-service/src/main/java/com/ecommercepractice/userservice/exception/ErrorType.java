package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    USER_ALREADY_CREATED("UserAlreadyCreatedException", HttpStatus.CONFLICT),
    USER_NOT_FOUND("UserNotFoundException", HttpStatus.NOT_FOUND);

    private String label;
    private HttpStatus status;
    public GeneralErrorType generateGeneral(){
        return new GeneralErrorType(label, status);
    }
}
