package com.fakeservers.cardFake.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    MISSING_FIELDS       ("MissingFieldsBody", HttpStatus.BAD_REQUEST),
    CARD_NOT_FOUND ("CardNotFoundException", HttpStatus.NOT_FOUND),
    WRONG_CREDENTIALS ("CardCredentialsWrongException", HttpStatus.UNAUTHORIZED)
    ;
    private String label;
    private HttpStatus status;
}
