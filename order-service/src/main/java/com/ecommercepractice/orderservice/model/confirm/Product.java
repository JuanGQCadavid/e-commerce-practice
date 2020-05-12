package com.ecommercepractice.orderservice.model.confirm;

import lombok.Data;

@Data
public class Product {
    private Integer productId;
    private Integer quantity;
    private Integer price;
}
