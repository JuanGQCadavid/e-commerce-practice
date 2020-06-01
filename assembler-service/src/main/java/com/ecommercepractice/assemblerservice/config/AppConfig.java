package com.ecommercepractice.assemblerservice.config;

import com.ecommercepractice.assemblerservice.services.AuthServices;
import com.ecommercepractice.assemblerservice.services.UserServices;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class AppConfig {

    @Value("${users.base.url}")
    private String usersEndpoint;

    @Value("${auth.base.url}")
    private String authEndpoint;

    @Bean
    public AuthServices retrofitAuth(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(authEndpoint)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(customOkHttpClient())
                .build();
        return retrofit.create(AuthServices.class);
    }

    @Bean
    public UserServices retrofitUser(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(usersEndpoint)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(customOkHttpClient())
                .build();
        return retrofit.create(UserServices.class);
    }

    private ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    private OkHttpClient customOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new ResponseCodeCheckInterceptor())
                .build();
        return okHttpClient;
    }

}
