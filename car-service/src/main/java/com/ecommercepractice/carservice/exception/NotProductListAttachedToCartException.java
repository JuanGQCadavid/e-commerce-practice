package com.ecommercepractice.carservice.exception;

/**
 * When a product is being requested but it is not attached to the cart.
 */
public class NotProductListAttachedToCartException extends CartException {
    public NotProductListAttachedToCartException(Integer idCart) {
        super(String.format("There is not a list of products associated to the cart id {%d}",idCart), idCart, ErrorType.NOT_LIST_ATTACHED);
    }
}
