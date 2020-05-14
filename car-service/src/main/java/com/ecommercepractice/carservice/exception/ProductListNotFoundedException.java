package com.ecommercepractice.carservice.exception;

/**
 * Internal error, the list attached to a cart does not exist.
 */
public class ProductListNotFoundedException extends CartException {
    public ProductListNotFoundedException(Integer idProductList ) {
        super(String.format("The product's list id { %d } could not be founded", idProductList), idProductList, ErrorType.PRODUCT_LIST_NOT_FOUNDED);
    }
}
