package com.ecommercepractice.paymentservice.service;

import com.ecommercepractice.paymentservice.models.CardMessage.PaymentMessage;
import com.ecommercepractice.paymentservice.models.responses.CardResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CardService {
    /**
     * Bridge that communicate with Card service.
     * @param paymentMessage -> Card Service contract.
     * @return
     */
    @POST("card/withdraw")
    Call<CardResponse> cardWithdraw(@Body PaymentMessage paymentMessage);
}
