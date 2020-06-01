package com.ecommercepractice.assemblerservice.exceptions;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    SERVICE_FAIL_RESPONSE("ServiceFailException", HttpStatus.CONFLICT);

    private String label;
    private HttpStatus status;

    public GeneralErrorType generateGeneral(){
        return new GeneralErrorType(label, status);
    }
}
