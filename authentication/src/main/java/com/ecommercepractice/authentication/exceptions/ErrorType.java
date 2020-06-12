package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Internal runtime exception flag.
 */
@AllArgsConstructor
@Getter
public enum ErrorType {
    EMAIL_ALREADY_USED    ("EmailAlreadyUsedException", HttpStatus.UNPROCESSABLE_ENTITY),
    EMAIL_NOT_FOUND       ("EmailNotFoundException", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD     ("InvalidUserPasswordException",HttpStatus.UNAUTHORIZED),
    MISSING_FIELDS       ("MissingFieldsBody",HttpStatus.BAD_REQUEST),
    EXPIRED_TOKEN        ("ExpiredUserTokenException",HttpStatus.FORBIDDEN),
    INVALID_TOKEN        ("InvalidUserTokenException",HttpStatus.UNAUTHORIZED),
    TOKEN_NO_FOUND        ("TokenNotFoundException",HttpStatus.UNAUTHORIZED),
    MISSING_AUTH_HEADER  ("MissingAuthenticationHeaderException",HttpStatus.UNAUTHORIZED)
    ;

    private final String label;
    private HttpStatus status;
    public GeneralErrorType generateGeneral(){
        return new GeneralErrorType(label, status);
    }
}