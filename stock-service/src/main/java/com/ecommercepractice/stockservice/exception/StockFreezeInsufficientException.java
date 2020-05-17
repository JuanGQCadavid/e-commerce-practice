package com.ecommercepractice.stockservice.exception;

import com.ecommercepractice.stockservice.model.Stock;
import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

/**
 * When buying, the freeze stock must be greater or equals than
 * the sold amount, if not this error should arise.
 */
public class StockFreezeInsufficientException extends GeneralException {
    public StockFreezeInsufficientException(Stock stock, Long boughtQuantity) {
        super(String.format("Stock { %s } does not have enough freeze quantities to sell { %d }",stock,boughtQuantity),
                ErrorType.INSUFFICIENT_FREEZE.generateGeneral(), new Pair<Stock, Long>(stock,boughtQuantity));
    }
}
