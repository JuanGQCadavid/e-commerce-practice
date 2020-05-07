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

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idCard;

    @NotNull
    private String ownerFirstName;

    @NotNull
    private String ownerLastName;
}
