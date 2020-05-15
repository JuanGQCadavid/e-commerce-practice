package com.ecommercepractice.carservice.exception;

import com.ecommercepractice.carservice.util.Pair;

/**
 * If the product id that is being requested does not belong to the user's cart
 * then this exception should arise.
 */
public class ProductIdNotFoundedException extends CartException {
    public ProductIdNotFoundedException(Integer idProductList,Integer idProduct) {
        super(String.format("The product with id {%d} could not be founded inside product list {%d}",idProduct,idProductList),
                new Pair<Integer,Integer>(idProductList, idProduct), ErrorType.NOT_PRODUCT_LISTED);
    }
}
