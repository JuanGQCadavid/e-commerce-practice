package com.fakeservers.cardFake.exceptions;

import com.fakeservers.cardFake.util.Pair;

public class CardCredentialsWrongException extends  CardException {
    public CardCredentialsWrongException(String tccNumber) {
        super(String.format("Wrong card credentials for tcc {%s}", tccNumber),
                new Pair("tccNumber", tccNumber), ErrorType.WRONG_CREDENTIALS);
    }
}
