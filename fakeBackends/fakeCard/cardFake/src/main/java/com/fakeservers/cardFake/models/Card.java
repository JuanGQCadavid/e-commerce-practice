package com.fakeservers.cardFake.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {

    @Id
    private Integer idCard;

    @NotEmpty
    private String tccNumber;

    @NotEmpty
    private String securityCode;

    @NotEmpty
    private String expirationData;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    private Double amount;

}
