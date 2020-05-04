package com.ecommercepractice.carservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * product list model, Primary Key (productListId) and a
 * related quantity
 */
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductList {


    @EmbeddedId
    private ProductListId productListId;

    @ApiModelProperty("Quantity of products to buy")
    @NotNull
    private Integer quantity;

}
