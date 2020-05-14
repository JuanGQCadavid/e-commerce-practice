package com.ecommercepractice.stockservice.exception;

import com.ecommercepractice.stockservice.model.Stock;

/**
 * When freezing the stock available for that action is
 * less than the necessary.
 */
public class InsufficientStockException extends StockException {
    public InsufficientStockException(Stock stock) {
        super(String.format("Insufficient stock available"), stock, ErrorType.INSUFFICIENT_STOCK);
    }
}