package com.ecommercepractice.stockservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ws.rs.QueryParam;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTO {

    @QueryParam(value = "price")
    private Float price;

    @QueryParam(value = "stockQuantity")
    private Long stockQuantity;

    @QueryParam(value = "soldQuantity")
    private Long soldQuantity;

    @QueryParam(value = "onlyActive")
    private Boolean onlyActive;

}
