package com.ecommercepractice.assemblerservice.models.stockModels.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockProduct {
    @ApiModelProperty("Stock's id")
    private Long idInventory;

    @NotNull
    @ApiModelProperty("Stock's product's id")
    private Long idProduct;

    @NotNull
    @ApiModelProperty("Stock's Quantity available for being sold")
    private Long stockQuantity;

    @ApiModelProperty("Stock's sold quantity")
    private Long soldQuantity;

    @ApiModelProperty("Stock's freeze quantity, middle step towards a purchased")
    private Long freezeQuantity;

    @NotNull
    @ApiModelProperty("Stock's sales price")
    private Float salePrice;

    @ApiModelProperty("Stock's active state")
    private boolean isActive;
}
