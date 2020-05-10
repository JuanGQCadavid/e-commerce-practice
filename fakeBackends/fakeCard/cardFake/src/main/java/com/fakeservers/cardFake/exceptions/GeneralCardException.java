package com.fakeservers.cardFake.exceptions;

import com.fakeservers.cardFake.util.Pair;

public class GeneralCardException extends CardException {
    public GeneralCardException(String tccNumber) {
        super(String.format("The transaction on tcc card {%s} could not be processed.",tccNumber),
                new Pair<String,String>("tccNumber", tccNumber),ErrorType.GENERAL_ERROR);
    }
}
