package com.ecommercepractice.paymentservice.controller;

import com.ecommercepractice.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping("/nequi/{cardId}/cashout")
    public void performPayment(@PathVariable Integer cardId){

    }

}

