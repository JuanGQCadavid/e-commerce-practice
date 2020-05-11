package com.ecommercepractice.paymentservice.service;

import com.ecommercepractice.paymentservice.models.CardMessage.PaymentMessage;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentInfo;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentTypeInfo;
import com.ecommercepractice.paymentservice.models.responses.CardResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;


@AllArgsConstructor
@Service
public class PaymentService {
    @Autowired
    CardService cardService;

    public void performCardPayment(String amount, PaymentTypeInfo paymentTypeInfo) {
        PaymentMessage paymentMessage = new PaymentMessage(
                paymentTypeInfo,new PaymentInfo(LocalDate.now().toString(),amount)
        );

        Response<CardResponse> responseCall = null;
        try {
            responseCall = cardService.cardWithdraw(paymentMessage).execute();

            if(responseCall.isSuccessful()){
                System.out.println(responseCall.body());
            }else{
                System.out.println(responseCall.errorBody().toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fetchPaymentById(Integer idPayment) {
    }

    public void fetchAllBills() {
    }


}
