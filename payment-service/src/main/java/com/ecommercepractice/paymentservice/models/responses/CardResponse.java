package com.ecommercepractice.paymentservice.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
 * DTO use at card response.
 */
public class CardResponse {
    private String bill;
}
