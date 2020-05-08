package com.fakeservers.cardFake.service;

import com.fakeservers.cardFake.exceptions.CardCredentialsWrongException;
import com.fakeservers.cardFake.exceptions.CardNotFoundException;
import com.fakeservers.cardFake.models.Card;
import com.fakeservers.cardFake.models.PaymentMessage;
import com.fakeservers.cardFake.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public HashMap<String,String> withdraw(PaymentMessage paymentMessage) {
        String tccNumber = paymentMessage.getPaymentTypeInfo().getTccNumber();
        Card actualCard = Optional.ofNullable(cardRepository.findByTccNumber(tccNumber))
                .orElseThrow(() -> new CardNotFoundException(tccNumber));

        return validateCardCredentials(paymentMessage, actualCard);
    }

    private HashMap<String,String> validateCardCredentials(PaymentMessage paymentMessage, Card actualCard) {
        HashMap<String,String> response = new HashMap<>();

        if(paymentMessage.getPaymentTypeInfo().getTccNumber().equals(actualCard.getTccNumber())
            && paymentMessage.getPaymentTypeInfo().getSecurityCode().equals(actualCard.getSecurityCode())
                && paymentMessage.getPaymentTypeInfo().getExpirationData().equals((actualCard.getExpirationData()))
        ) {
            response.put("bill", UUID.randomUUID().toString());
            return response;
        }else{
            throw new CardCredentialsWrongException(paymentMessage.getPaymentTypeInfo().getTccNumber());
        }
    }

    public List<Card> fetchAll() {
        return cardRepository.findAll();
    }
}
