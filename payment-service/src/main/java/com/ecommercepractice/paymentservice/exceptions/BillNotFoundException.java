package com.ecommercepractice.paymentservice.exceptions;

import com.ecommercepractice.paymentservice.util.Pair;

/**
 * When the bill is no founded onto the Server repository
 * this exception should arise.
 */
public class BillNotFoundException extends PaymentException {
    public BillNotFoundException(String billNumber) {
        super(String.format("Bill number {%s} could not be found", billNumber), ErrorType.BILL_NOT_FOUND,
                new Pair<String,String>("BillNumber", billNumber));
    }
}