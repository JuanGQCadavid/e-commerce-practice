package com.ecommercepractice.paymentservice.models.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class ValidateClientRQ {
    private String phoneNumber;
    private String value;
}
