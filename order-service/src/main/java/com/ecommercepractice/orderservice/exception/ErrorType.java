package com.ecommercepractice.orderservice.exception;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import com.ecommercepractice.utilities.exception.GeneralException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Internal runtime exception flag.
 */
@Getter
@AllArgsConstructor
public enum ErrorType {
    MISSING_FIELDS       ("MissingFieldsBody",HttpStatus.BAD_REQUEST),
    ORDER_BY_ID_NOT_FOUND    ("OrderByIdNotFoundException", HttpStatus.NOT_FOUND);

    private String label;
    private HttpStatus status;

    public GeneralErrorType generateGeneral(){
        return new GeneralErrorType(label, status);
    }

}
