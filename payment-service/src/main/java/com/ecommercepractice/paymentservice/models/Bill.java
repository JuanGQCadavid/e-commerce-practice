package com.ecommercepractice.paymentservice.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bill {
    @ApiModelProperty(value = "Internal id")
    private Integer idPayment;

    @ApiModelProperty(value = "Withdraw's performing Date")
    private LocalDate date;

    @ApiModelProperty(value = "Withdraw's amount ")
    private String amount;

    @ApiModelProperty(value = "Withdraw's payment method, CARD by the moment")
    private String paymentMethod;

    @ApiModelProperty(value = "invoice from card service, and the identifier of the bill")
    private String billNumber;

    public Bill(Payment payment){
        this.idPayment = payment.getIdPayment();
        this.date = payment.getDate();
        this.amount = payment.getAmount();
        this.paymentMethod = "CARD";
        this.billNumber = payment.getBillNumber();
    }
}
