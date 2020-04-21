package com.ecommercepractice.productservice.exception;

import lombok.Getter;

/**
 * Internal runtime exception flag.
 */

@Getter
public enum ErrorType {
    PRODUCT_NOT_CREATED("ProductNotCreated"),
    MISSING_FIELDS       ("MissingFieldsBody"),
    PRODUCT_NOT_FOUNDED("ProductNotFoundedException");

    private String label;

    ErrorType(String label){
        this.label = label;
    }
}
