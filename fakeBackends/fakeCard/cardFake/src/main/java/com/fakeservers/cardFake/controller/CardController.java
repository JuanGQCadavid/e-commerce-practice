package com.fakeservers.cardFake.controller;

import com.fakeservers.cardFake.models.Card;
import com.fakeservers.cardFake.models.PaymentMessage;
import com.fakeservers.cardFake.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/withdraw")
    public ResponseEntity<HashMap<String,Object>> withdraw(@Valid @RequestBody PaymentMessage paymentMessage){
        log.info(String.format("CARD | WITHDRAW | {%s}", paymentMessage.getPaymentTypeInfo().getOwner().getFirstName()));
        return new ResponseEntity(cardService.withdraw(paymentMessage), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Card>> checkCards (){
        return new ResponseEntity(cardService.fetchAll(), HttpStatus.OK);
    }
}
