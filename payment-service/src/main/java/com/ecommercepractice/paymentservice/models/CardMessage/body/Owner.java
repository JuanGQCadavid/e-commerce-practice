package com.ecommercepractice.paymentservice.models.CardMessage.body;

import javax.validation.constraints.NotEmpty;

public class Owner {
    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String address;
}
