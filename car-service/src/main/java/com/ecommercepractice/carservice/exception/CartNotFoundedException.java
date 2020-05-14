package com.ecommercepractice.carservice.exception;

/**
 * When someone is attempting to access to a cart that does not exist
 */
public class CartNotFoundedException extends CartException {
    public CartNotFoundedException(Integer idCart) {
        super(String.format("The cart with id { %d } could not be founded", idCart), idCart, ErrorType.CART_NOT_FOUNDED);
    }
}
