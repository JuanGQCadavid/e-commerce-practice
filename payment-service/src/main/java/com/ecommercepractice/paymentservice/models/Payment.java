package com.ecommercepractice.paymentservice.models;

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
import java.util.UUID;

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
    private Double amount;

    @NotNull
    private String ownerFirstName;

    @NotNull
    private String ownerLastName;

    private UUID billNumber;

}
