package com.ecommercepractice.paymentservice.models.CardMessage.body;
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
public class PaymentInfo {
    private String paymentDate;
    private String amount;
}
