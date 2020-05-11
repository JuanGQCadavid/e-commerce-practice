package com.ecommercepractice.paymentservice.exceptions;

import com.ecommercepractice.paymentservice.models.responses.CardFail;

public class CardServiceException extends PaymentException {
    public CardServiceException(CardFail cardFail) {
        super("Request rejected by Card Service", ErrorType.CARD_FAIL, cardFail);
    }
}
