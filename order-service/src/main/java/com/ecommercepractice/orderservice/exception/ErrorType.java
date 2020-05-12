package com.ecommercepractice.orderservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Internal runtime exception flag.
 */
@Getter
@AllArgsConstructor
public enum ErrorType {
    MISSING_FIELDS       ("MissingFieldsBody",HttpStatus.BAD_REQUEST);

    private String label;
    private HttpStatus status;
}
