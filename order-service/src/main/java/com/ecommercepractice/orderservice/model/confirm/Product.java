package com.ecommercepractice.orderservice.model.confirm;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Part of client contract for confirmation endpoint.
 * Specified products information.
 */
@Data
public class Product {
    @NotEmpty
    private Integer productId;

    @NotEmpty
    private Integer quantity;

    @NotEmpty
    private Integer price;
}
