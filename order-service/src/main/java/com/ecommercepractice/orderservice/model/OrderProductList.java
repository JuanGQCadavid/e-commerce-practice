package com.ecommercepractice.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderProductList {
    @EmbeddedId
    private OrderProductListId orderProductListId;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer salePrice;
}
