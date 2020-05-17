package com.ecommercepractice.stockservice.exception;
import com.ecommercepractice.utilities.exception.GeneralErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
/**
 * Internal runtime exception flag with their corresponding http responses.
 */
@Getter
@AllArgsConstructor
public enum ErrorType {
    MISSING_FIELDS("MissingFieldsBody",HttpStatus.BAD_REQUEST),
    PRODUCT_ALREADY_ACTIVE("ProductAlreadyOnInventory", HttpStatus.NOT_ACCEPTABLE),
    STOCK_NOT_FOUND("StockNotFoundedException", HttpStatus.NOT_FOUND),
    INSUFFICIENT_STOCK("InsufficientStockException", HttpStatus.CONFLICT),
    INSUFFICIENT_FREEZE("StockFreezeInsufficientException", HttpStatus.CONFLICT);

    private String label;
    private HttpStatus status;
    public GeneralErrorType generateGeneral(){
        return new GeneralErrorType(label, status);
    }
}
