package com.fakeservers.cardFake.models;

import com.fakeservers.cardFake.models.body.PaymentInfo;
import com.fakeservers.cardFake.models.body.PaymentTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMessage {
    private PaymentTypeInfo paymentTypeInfo;
    private PaymentInfo paymentInfo;
}