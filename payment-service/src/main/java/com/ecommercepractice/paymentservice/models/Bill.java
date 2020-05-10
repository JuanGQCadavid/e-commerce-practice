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
    private Double amount;
    private String paymentMethod;
    private UUID billNumber;
}
