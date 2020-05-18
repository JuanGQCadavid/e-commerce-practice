package com.ecommercepractice.paymentservice.exceptions;

import com.ecommercepractice.paymentservice.models.responses.CardFail;
import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * When card's Service failed, the server should arise this
 * exception indicating the server response.
 */
public class CardServiceException extends GeneralException {
    public CardServiceException(CardFail cardFail) {
        super("Request rejected by Card Service", ErrorType.CARD_FAIL.generateGeneral(), cardFail);
    }
}
