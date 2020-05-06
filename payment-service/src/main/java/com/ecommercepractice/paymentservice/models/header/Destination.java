package com.ecommercepractice.paymentservice.models.header;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Destination {
    @JsonProperty("ServiceName")
    private String serviceName;

    @JsonProperty("ServiceOperation")
    private String serviceOperation;

    @JsonProperty("ServiceRegion")
    private String serviceRegion;

    @JsonProperty("ServiceVersion")
    private String serviceVersion;
}
