package com.ecommercepractice.assemblerservice.models.stockModels.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockProduct {
    @ApiModelProperty("Stock's id")
    private Long idInventory;

    @ApiModelProperty("Stock's product's id")
    private Long idProduct;

    @ApiModelProperty("Stock's Quantity available for being sold")
    private Long stockQuantity;

    @ApiModelProperty("Stock's sold quantity")
    private Long soldQuantity;

    @ApiModelProperty("Stock's freeze quantity, middle step towards a purchased")
    private Long freezeQuantity;

    @ApiModelProperty("Stock's sales price")
    private Float salePrice;

    @ApiModelProperty("Stock's active state")
    private boolean isActive;
}
