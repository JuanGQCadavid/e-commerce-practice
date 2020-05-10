package com.ecommercepractice.paymentservice.service;

import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentTypeInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentService {
    @Autowired
    CardService cardService;

    public void performCardPayment(Double amount, PaymentTypeInfo paymentTypeInfo) {
    }

    public void fetchPaymentById(Integer idPayment) {
    }

    public void fetchAllBills() {
    }


}
