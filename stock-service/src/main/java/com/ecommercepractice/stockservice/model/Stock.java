package com.ecommercepractice.stockservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel("Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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
