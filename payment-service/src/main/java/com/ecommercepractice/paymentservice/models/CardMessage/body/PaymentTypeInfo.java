package com.ecommercepractice.paymentservice.models.CardMessage.body;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaymentTypeInfo {
    @NotEmpty
    private String tccNumber;

    @NotEmpty
    private String securityCode;

    @NotEmpty
    private String expirationData;

    @NotNull
    @Valid
    private Owner owner;
}
