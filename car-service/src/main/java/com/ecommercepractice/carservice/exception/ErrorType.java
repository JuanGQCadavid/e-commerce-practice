package com.ecommercepractice.carservice.exception;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Error types that maps internal errors threw by the CartExceptions family.
 */
@Getter
@AllArgsConstructor
public enum ErrorType {
    MISSING_FIELDS("MissingFieldsBody",HttpStatus.BAD_REQUEST),
    PRODUCT_LIST_NOT_FOUNDED("ProductListNotFoundedException", HttpStatus.NOT_FOUND),
    CART_NOT_FOUNDED("CartNotFoundedException", HttpStatus.NOT_FOUND),
    CART_NOT_ACTIVE("CartNotActiveException", HttpStatus.NOT_ACCEPTABLE),
    PRODUCT_ID_ALREADY_IN_PRODUCT_LIST("ProductIdAlreadyInProductListException", HttpStatus.CONFLICT),
    NOT_LIST_ATTACHED("NotProductListAttachedToCartException", HttpStatus.NOT_FOUND),
    NOT_PRODUCT_LISTED("ProductIdNotFoundedException", HttpStatus.NOT_FOUND);

    private String label;
    private HttpStatus status;
    public GeneralErrorType generateGeneral(){
        return new GeneralErrorType(label, status);
    }
}
