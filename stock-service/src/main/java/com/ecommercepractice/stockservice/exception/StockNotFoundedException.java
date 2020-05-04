package com.ecommercepractice.stockservice.exception;
/**
 * The stock the user request is no registered.
 */
public class StockNotFoundedException extends StockException{
    public StockNotFoundedException(Long stockID) {
        super(String.format("The Stock with id { %s} does not exist.", stockID.toString()), stockID, ErrorType.STOCK_NOT_FOUND);
    }
}
