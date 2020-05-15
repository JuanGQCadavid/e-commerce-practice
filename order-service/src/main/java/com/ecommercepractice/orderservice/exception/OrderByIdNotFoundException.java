package com.ecommercepractice.orderservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

/**
 * When an order could not be fetched by its orderId
 * an OrderByIdNotFound should arise
 */
public class OrderByIdNotFoundException extends GeneralException {
    public OrderByIdNotFoundException(Integer orderId) {
        super(String.format("Order identified by OrderId # {%s} could not be founded", orderId.toString()),
                ErrorType.ORDER_BY_ID_NOT_FOUND.generateGeneral(), new Pair<String,Integer>("OrderId", orderId));
    }
}
