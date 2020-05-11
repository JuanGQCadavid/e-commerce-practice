package com.ecommercepractice.paymentservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bill {
    private Integer idPayment;
    private LocalDate date;
    private String amount;
    private String paymentMethod;
    private String billNumber;

    public Bill(Payment payment){
        this.idPayment = payment.getIdPayment();
        this.date = payment.getDate();
        this.amount = payment.getAmount();
        this.paymentMethod = "CARD";
        this.billNumber = payment.getBillNumber();
    }
}
