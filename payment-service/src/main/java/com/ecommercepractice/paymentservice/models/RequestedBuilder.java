package com.ecommercepractice.paymentservice.models;

import com.ecommercepractice.paymentservice.models.body.Any;
import com.ecommercepractice.paymentservice.models.body.RequestBody;
import com.ecommercepractice.paymentservice.models.body.ValidateClientRQ;
import com.ecommercepractice.paymentservice.models.header.Address;
import com.ecommercepractice.paymentservice.models.header.Destination;
import com.ecommercepractice.paymentservice.models.header.RequestHeader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

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
