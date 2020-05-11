package com.ecommercepractice.paymentservice.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardFail {
    private String timeStamp;

    private String message;

    private String errorType;

    private Object payload;
}
