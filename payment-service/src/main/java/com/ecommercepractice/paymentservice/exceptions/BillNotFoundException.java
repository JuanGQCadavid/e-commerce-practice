package com.ecommercepractice.paymentservice.exceptions;

import com.ecommercepractice.paymentservice.util.Pair;

public class BillNotFoundException extends PaymentException {
    public BillNotFoundException(String billNumber) {
        super(String.format("Bill number {%s} could not be found", billNumber), ErrorType.BILL_NOT_FOUND,
                new Pair<String,String>("BillNumber", billNumber));
    }
}