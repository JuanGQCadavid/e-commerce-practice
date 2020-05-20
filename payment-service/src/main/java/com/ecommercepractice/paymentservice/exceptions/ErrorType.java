package com.ecommercepractice.paymentservice.exceptions;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    MISSING_FIELDS ("MissingFieldsBody", HttpStatus.BAD_REQUEST),
    CARD_FAIL("CardServiceFail", HttpStatus.CONFLICT),
    BILL_NOT_FOUND("BillNotFoundException",HttpStatus.NOT_FOUND)
    ;

    private String label;
    private HttpStatus status;

    public GeneralErrorType generateGeneral(){
        return new GeneralErrorType(label, status);
    }

}
