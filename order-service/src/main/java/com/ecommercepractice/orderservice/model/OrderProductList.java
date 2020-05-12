package com.ecommercepractice.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductList {
    @EmbeddedId
    private OrderProductListId orderProductListId;

    private Integer quantity;
}
