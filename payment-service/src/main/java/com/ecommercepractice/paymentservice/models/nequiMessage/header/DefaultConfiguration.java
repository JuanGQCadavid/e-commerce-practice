package com.ecommercepractice.paymentservice.models.nequiMessage.header;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfiguration {

    @Bean(name = "validateClient")
    public Destination validateClient(){
        return new Destination("RechargeService","validateClient","C001","1.4.0");
    }

    @Bean(name = "defaultAddress")
    public Address defaultAddress(){
        return new Address("1.1.1.1", "1.1.1.1");
    }
}
