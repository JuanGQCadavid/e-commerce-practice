package com.ecommercepractice.paymentservice.controller;

import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentTypeInfo;
import com.ecommercepractice.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/payment")
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping("/nequi/{userPhoneNumber}/cashout/{quantity}")
    public void performNequiPayment(@PathVariable Integer userPhoneNumber, @PathVariable Integer quantity){
        log.info(String.format("PAYMENT | NEQUI | CASHOUT { QUANTITY -> %d} ", quantity));
        paymentService.performNequiPayment(userPhoneNumber,quantity);
    }

    @PostMapping("/card/{amount}")
    public void performCardPayment(@PathVariable Double amount, @Valid @RequestBody PaymentTypeInfo paymentTypeInfo){
        log.info(String.format("PAYMENT | CARD | DEBIT { QUANTITY -> %d} ", amount));
        paymentService.performCardPayment(amount,paymentTypeInfo);
    }

    @GetMapping("/bills")
    public void fetchAllBills(){
        log.info(String.format("PAYMENT | BILLS"));
        paymentService.fetchAllBills();
    }

    @GetMapping("/{idPayment}/bill")
    public void fetchPaymentById(@PathVariable Integer idPayment){
        log.info(String.format("PAYMENT | FETCH BILL { %d }", idPayment));
        paymentService.fetchPaymentById(idPayment);
    }

}

