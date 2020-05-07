package com.ecommercepractice.paymentservice.service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobileconnectors.apigateway.ApiClientFactory;
import com.ecommercepractice.paymentservice.models.nequiMessage.RequestedBuilder;
import com.google.gson.JsonObject;
import com.nequi.api.client.NequiGatewayClient;
import com.nequi.api.provider.BasicAWSCredentialsProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Component
public class NequiService {

    @Autowired
    RequestedBuilder requestedBuilder;

    private final String ACCESS_KEY  = "AKIASSSPECJGLVEOXGDH";
    private final String SECRET_KEY = "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";
    private final String API_KEY = "TNoGGK0nSgaGIL6iZT5kB4bmABSsj7YRV8SGcg11";
    private NequiGatewayClient apiClient;

    public NequiService (){
        AWSCredentialsProvider credentialsProvider = new BasicAWSCredentialsProvider(ACCESS_KEY,SECRET_KEY);
        apiClient = new ApiClientFactory()
                .apiKey(API_KEY)
                .credentialsProvider(credentialsProvider)
                .build(NequiGatewayClient.class);
    }

    public void checkUser(String phoneNumber, String value){
        System.out.println(requestedBuilder.validationClient(phoneNumber, value));
        JsonObject response = apiClient.servicesClientserviceValidateclientPost(requestedBuilder.validationClient(phoneNumber, value));
        System.out.println(response);
    }

}
