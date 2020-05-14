package com.ecommercepractice.carservice.exception;

import com.ecommercepractice.carservice.util.Pair;

/**
 * If the user attempts to append a product that is actually on the cart
 * this exception should arise.
 */
public class ProductIdAlreadyInProductListException extends CartException {
    public ProductIdAlreadyInProductListException(Integer idProductList, Integer productId) {
        super(String.format("The product id { %d } on products list {%d} is already defined, you should perform PUT instead.", productId, idProductList),
                new Pair<Integer,Integer>(idProductList, productId), ErrorType.PRODUCT_ID_ALREADY_IN_PRODUCT_LIST);
    }
}
