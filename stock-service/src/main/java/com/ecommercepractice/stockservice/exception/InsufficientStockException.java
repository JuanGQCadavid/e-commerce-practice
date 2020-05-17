package com.ecommercepractice.stockservice.exception;

import com.ecommercepractice.stockservice.model.Stock;
import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * When freezing the stock available for that action is
 * less than the necessary.
 */
public class InsufficientStockException extends GeneralException {
    public InsufficientStockException(Stock stock) {
        super(String.format("Insufficient stock available"), ErrorType.INSUFFICIENT_STOCK.generateGeneral(), stock);
    }
}