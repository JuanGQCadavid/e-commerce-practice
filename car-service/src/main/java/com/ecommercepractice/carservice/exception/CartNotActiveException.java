package com.ecommercepractice.carservice.exception;

/**
 * When the request attempts to access to a cart that is not longer active.
 */
public class CartNotActiveException extends CartException {
    public CartNotActiveException(Integer idCart) {
        super(String.format("The cart with id { %d } exists but, it's not long active ",idCart), idCart, ErrorType.CART_NOT_ACTIVE);
    }
}
