package com.ecommercepractice.paymentservice.controller;

import com.ecommercepractice.paymentservice.models.Bill;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentTypeInfo;
import com.ecommercepractice.paymentservice.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/v1/payment")
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @ApiOperation(value = "WITHDRAW FROM CARD", notes = "Withdraw an explicit amount from a card account against Card server.")
    @PostMapping("/card/withdraw")
    public ResponseEntity<Bill> performCardPayment(@Valid @RequestBody PaymentTypeInfo paymentTypeInfo){
        log.info(String.format("PAYMENT | CARD | DEBIT { QUANTITY -> %s} ", paymentTypeInfo.getAmount()));
        return new ResponseEntity(paymentService.performCardPayment(paymentTypeInfo), HttpStatus.CREATED);
    }
    @ApiOperation(value = "FETCH ALL BILLS", notes = "Fetch all bills that were successfully performed.")
    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> fetchAllBills(){
        log.info(String.format("PAYMENT | BILLS"));
        return new ResponseEntity(paymentService.fetchAllBills(), HttpStatus.OK);
    }
    @ApiOperation(value = "FETCH BY BILL NUMBER", notes = "Fetch a bill by its bill number.")
    @GetMapping("/bills/{billNumber}")
    public ResponseEntity<Bill> fetchPaymentByBillNumber(@PathVariable String billNumber){
        log.info(String.format("PAYMENT | FETCH BILL { %s }", billNumber));
        return new ResponseEntity(paymentService.fetchPaymentByBillNumber(billNumber), HttpStatus.OK);
    }
}

