package com.ecommercepractice.carservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * Internal error, the list attached to a cart does not exist.
 */
public class ProductListNotFoundedException extends GeneralException {
    public ProductListNotFoundedException(Integer idProductList ) {
        super(String.format("The product's list id { %d } could not be founded", idProductList),
                ErrorType.PRODUCT_LIST_NOT_FOUNDED.generateGeneral(), idProductList);
    }
}
