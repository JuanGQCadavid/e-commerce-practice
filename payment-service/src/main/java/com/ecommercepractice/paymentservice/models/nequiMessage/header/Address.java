package com.ecommercepractice.paymentservice.models.nequiMessage.header;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @JsonProperty("DeviceAddress")
    private String deviceAddress;

    @JsonProperty("NetworkAddress")
    private String networkAddress;
}
