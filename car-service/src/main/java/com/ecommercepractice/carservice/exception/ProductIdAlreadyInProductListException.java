package com.ecommercepractice.carservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

/**
 * If the user attempts to append a product that is actually on the cart
 * this exception should arise.
 */
public class ProductIdAlreadyInProductListException extends GeneralException {
    public ProductIdAlreadyInProductListException(Integer idProductList, Integer productId) {
        super(String.format("The product id { %d } on products list {%d} is already defined, you should perform PUT instead.", productId, idProductList),
                ErrorType.PRODUCT_ID_ALREADY_IN_PRODUCT_LIST.generateGeneral(), new Pair<Integer,Integer>(idProductList, productId));
    }
}
