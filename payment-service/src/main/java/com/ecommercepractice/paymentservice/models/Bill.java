package com.ecommercepractice.paymentservice.models;

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
    private Integer idPayment;
    private LocalDate date;
    private Double amount;
    private String paymentMethod;
}
