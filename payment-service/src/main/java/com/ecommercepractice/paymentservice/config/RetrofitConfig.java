package com.ecommercepractice.paymentservice.config;

import com.ecommercepractice.paymentservice.service.CardService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${card.base.url}")
    private String cardEndpoint;

    @Bean
    public CardService retrofitCard(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(cardEndpoint)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper()))
                .build();
        return retrofit.create(CardService.class);
    }

    private ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper;
    }
}
