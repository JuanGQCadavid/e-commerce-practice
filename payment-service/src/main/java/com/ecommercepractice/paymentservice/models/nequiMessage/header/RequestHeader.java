package com.ecommercepractice.paymentservice.models.nequiMessage.header;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class RequestHeader {
    @JsonProperty("Channel")
    private String channel;

    @JsonProperty("RequestDate")
    private String requestDate;

    @JsonProperty("MessageID")
    private String messageID;

    @JsonProperty("ClientID")
    private String clientID;

    @JsonProperty("Address")
    private Address address;

    @JsonProperty("Destination")
    private Destination destination;

    public RequestHeader(String channel, String clientID, Destination destination, Address address){
        this.channel = channel;
        this.clientID = clientID;
        this.requestDate = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").format(new Date());
        String milliseconds = Long.toString(System.currentTimeMillis());
        this.messageID = milliseconds.substring(milliseconds.length()-9);
        this.destination = destination;
        this.address = address;
    }
}
