package com.ecommercepractice.paymentservice.models;

import com.ecommercepractice.paymentservice.models.CardMessage.PaymentMessage;
import com.ecommercepractice.paymentservice.models.responses.CardResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idPayment;

    @NotNull
    private LocalDate date;

    @NotNull
    private String amount;

    @NotNull
    private String ownerFirstName;

    @NotNull
    private String ownerLastName;

    @NotNull
    private String billNumber;

    public Payment(PaymentMessage paymentMessage, CardResponse billNumber){
        this.date = LocalDate.now();
        this.amount = paymentMessage.getPaymentInfo().getAmount();
        this.ownerFirstName = paymentMessage.getPaymentTypeInfo().getOwner().getFirstName();
        this.ownerLastName = paymentMessage.getPaymentTypeInfo().getOwner().getLastName();
        this.billNumber = billNumber.getBill();
    }
}
