package com.ecommercepractice.paymentservice.service;

import com.ecommercepractice.paymentservice.models.CardMessage.PaymentMessage;
import com.ecommercepractice.paymentservice.models.responses.CardResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CardService {
    @POST("card/withdraw")
    Call<CardResponse> cardWithdraw(@Body PaymentMessage paymentMessage);
}
