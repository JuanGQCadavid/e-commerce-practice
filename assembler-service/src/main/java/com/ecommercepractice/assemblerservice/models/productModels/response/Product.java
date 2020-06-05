package com.ecommercepractice.assemblerservice.models.productModels.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @ApiModelProperty(value = "Product's id")
    private long idProduct;

    @ApiModelProperty(value = "Product's name")
    private String name;

    @ApiModelProperty(value = "Product's description")
    private String description;

    @ApiModelProperty(value = "Product's price")
    private Double price;

    @ApiModelProperty(value = "Product's photo, if there is missing a default photo is going to be used instead")
    private String photoUrl;

}
