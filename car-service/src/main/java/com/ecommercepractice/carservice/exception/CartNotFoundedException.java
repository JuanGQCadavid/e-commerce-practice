package com.ecommercepractice.carservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * When someone is attempting to access to a cart that does not exist
 */
public class CartNotFoundedException extends GeneralException {
    public CartNotFoundedException(Integer idCart) {
        super(String.format("The cart with id { %d } could not be founded", idCart),
                ErrorType.CART_NOT_FOUNDED.generateGeneral(),idCart);
    }
}
