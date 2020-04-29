package com.ecommercepractice.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Internal runtime exception flag.
 */
@Getter
@AllArgsConstructor
public enum ErrorType {
    PRODUCT_NOT_CREATED("ProductNotCreated", HttpStatus.BAD_REQUEST),
    MISSING_FIELDS       ("MissingFieldsBody",HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUNDED("ProductNotFoundedException",HttpStatus.NOT_FOUND);

    private String label;
    private HttpStatus status;
}
