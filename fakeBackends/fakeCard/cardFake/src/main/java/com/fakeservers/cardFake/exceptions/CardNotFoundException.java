package com.fakeservers.cardFake.exceptions;

import com.fakeservers.cardFake.util.Pair;

public class CardNotFoundException extends CardException {
    public CardNotFoundException(String tccNumber) {
        super(String.format("Card with tccNumber {s} does not exist.", tccNumber),
                new Pair("tccNumber", tccNumber), ErrorType.CARD_NOT_FOUND);
    }
}
