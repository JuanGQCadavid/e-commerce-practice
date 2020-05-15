package com.ecommercepractice.orderservice.model.confirm;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Part of client contract for confirmation endpoint.
 * Specified products information.
 */
@Data
public class Product {
    @NotNull
    private Integer productId;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer price;
}
