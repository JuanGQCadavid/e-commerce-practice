package com.ecommercepractice.paymentservice.service;

import com.ecommercepractice.paymentservice.models.Bill;
import com.ecommercepractice.paymentservice.models.CardMessage.PaymentMessage;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentInfo;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentTypeInfo;
import com.ecommercepractice.paymentservice.models.Payment;
import com.ecommercepractice.paymentservice.models.responses.CardResponse;
import com.ecommercepractice.paymentservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class PaymentService {
    @Autowired
    CardService cardService;

    @Autowired
    PaymentRepository paymentRepository;

    public Bill performCardPayment(String amount, PaymentTypeInfo paymentTypeInfo) {
        PaymentMessage paymentMessage = new PaymentMessage(paymentTypeInfo,new PaymentInfo(LocalDate.now().toString(),amount));

        try {
            Response<CardResponse> responseCall = cardService.cardWithdraw(paymentMessage).execute();
            if(responseCall.isSuccessful()){
                return savePayment(paymentMessage,responseCall.body());
            }else{
                // Throws an exception.
                System.out.println(responseCall.errorBody().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Missing trows a new exception.
        return null;
    }

    private Bill savePayment(PaymentMessage paymentMessage, CardResponse bill) {
        Payment payment = paymentRepository.save(new Payment(paymentMessage,bill));
        return new Bill(payment);
    }

    public Bill fetchPaymentById(Integer idPayment) {
        // Missing this exception.
        Payment payment = paymentRepository.findById(idPayment)
                .orElseThrow( () -> new RuntimeException());
        return new Bill(payment);
    }

    public List<Bill> fetchAllBills() {
        List<Bill> bills = paymentRepository.findAll()
                .stream()
                .map(Bill::new)
                .collect(Collectors.toList());

        return bills;
    }


}
