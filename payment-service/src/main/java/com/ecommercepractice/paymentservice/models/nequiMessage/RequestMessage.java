package com.ecommercepractice.paymentservice.models.nequiMessage;

import com.ecommercepractice.paymentservice.models.nequiMessage.body.RequestBody;
import com.ecommercepractice.paymentservice.models.nequiMessage.header.RequestHeader;
import com.fasterxml.jackson.annotation.JsonProperty;
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
