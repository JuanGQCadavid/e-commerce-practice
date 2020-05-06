package com.ecommercepractice.paymentservice.models;

import com.ecommercepractice.paymentservice.models.body.RequestBody;
import com.ecommercepractice.paymentservice.models.header.RequestHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class RequestMessage {
    @JsonProperty("RequestMessage")
    Map<String,Object> requestMessage;

    public RequestMessage (RequestHeader requestHeader, RequestBody requestBody){
        requestMessage = new HashMap<>();
        requestMessage.put("RequestHeader", requestHeader);
        requestMessage.put("RequestBody", requestBody);
    }
}
