package com.ecommercepractice.paymentservice.models.CardMessage;

import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentInfo;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
/**
 * DTO for Card service communication.
 * Represents the contract at Card services.
 */
public class PaymentMessage {
    private PaymentTypeInfo paymentTypeInfo;
    private PaymentInfo paymentInfo;
}
