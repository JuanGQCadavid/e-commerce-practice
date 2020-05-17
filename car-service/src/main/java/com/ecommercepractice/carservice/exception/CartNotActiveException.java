package com.ecommercepractice.carservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * When the request attempts to access to a cart that is not longer active.
 */
public class CartNotActiveException extends GeneralException {
    public CartNotActiveException(Integer idCart) {
        super(String.format("The cart with id { %d } exists but, it's not long active ",idCart),
                ErrorType.CART_NOT_ACTIVE.generateGeneral(), idCart);
    }
}
