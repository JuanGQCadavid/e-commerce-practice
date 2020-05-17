package com.ecommercepractice.stockservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * The stock the user request is no registered.
 */
public class StockNotFoundedException extends GeneralException {
    public StockNotFoundedException(Long stockID) {
        super(String.format("The Stock with id { %s} does not exist.", stockID.toString()),
                ErrorType.STOCK_NOT_FOUND.generateGeneral(), stockID);
    }
}
