package com.ecommercepractice.assemblerservice.models.assemblerModels;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StockProductDTO {

    // ---- Stock data.

    @ApiModelProperty("Stock's id")
    private Long idInventory;

    @ApiModelProperty("Stock's available quantity")
    private Long availableQuantity;

    @ApiModelProperty("Stock's total quantity")
    private Long stockQuantity;

    @ApiModelProperty("Stock's sales price")
    private Float salePrice;

    // ---- Product's data.

    @ApiModelProperty(value = "Product's name")
    private String name;

    @ApiModelProperty(value = "Product's description")
    private String description;

    @ApiModelProperty(value = "Product's photo, if there is missing a default photo is going to be used instead")
    private String photoUrl;



}
