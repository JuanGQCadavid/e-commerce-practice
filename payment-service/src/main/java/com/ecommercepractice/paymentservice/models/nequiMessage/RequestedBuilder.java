package com.ecommercepractice.paymentservice.models.nequiMessage;

import com.ecommercepractice.paymentservice.models.nequiMessage.body.Any;
import com.ecommercepractice.paymentservice.models.nequiMessage.body.RequestBody;
import com.ecommercepractice.paymentservice.models.nequiMessage.body.ValidateClientRQ;
import com.ecommercepractice.paymentservice.models.nequiMessage.header.Address;
import com.ecommercepractice.paymentservice.models.nequiMessage.header.Destination;
import com.ecommercepractice.paymentservice.models.nequiMessage.header.RequestHeader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RequestedBuilder {
    @Autowired()
    @Qualifier("validateClient")
    Destination validationClientDest;

    @Autowired
    @Qualifier("defaultAddress")
    Address defaultAddress;

    public JsonObject validationClient(String phoneNumber, String value ) {
        RequestMessage requestMessage = new RequestMessage(
                new RequestHeader("MF-001","12345",validationClientDest, defaultAddress),
                new RequestBody(new Any(new ValidateClientRQ(phoneNumber,value)))
        );

        ObjectMapper oMapper = new ObjectMapper();
        //Map<String, Object> map = oMapper.convertValue(requestMessage,Map.class);
        String input ="";
        try{
            input = oMapper.writeValueAsString(requestMessage) ;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(input, JsonObject.class);
    }
}
