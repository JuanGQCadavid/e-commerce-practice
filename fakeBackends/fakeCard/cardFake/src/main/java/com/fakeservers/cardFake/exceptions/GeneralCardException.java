package com.fakeservers.cardFake.exceptions;

import com.fakeservers.cardFake.util.Pair;

public class GeneralCardException extends CardException {
    public GeneralCardException(String tccNumber) {
        super(String.format("The transaction on card could not be processed."),ErrorType.GENERAL_ERROR);
    }
}
