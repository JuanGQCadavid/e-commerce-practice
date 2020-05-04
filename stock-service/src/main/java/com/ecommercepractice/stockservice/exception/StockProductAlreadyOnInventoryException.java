package com.ecommercepractice.stockservice.exception;
/**
 * When creating a new stock's products, the product id could be registered,
 * but It must not be activated.
 */
public class StockProductAlreadyOnInventoryException extends  StockException {
    public StockProductAlreadyOnInventoryException(Long productId) {
        super(String.format("The product with id { %s } is already active in the inventory",productId.toString()),
                productId, ErrorType.PRODUCT_ALREADY_ACTIVE);
    }
}