package com.ecommercepractice.carservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idCart;

    @NotNull
    @ApiModelProperty("idUser that owns the carts")
    private Long idUser;

    @ApiModelProperty("Holds the id of the columns that denotes this actual cart with their products")
    private Integer idProductList;

    @ApiModelProperty("An Active product is one is actual o being used, there is only one per user")
    private Boolean isActive;

    @ApiModelProperty("Toggle denotes if a product is being save for future time.")
    private Boolean isSaved;
}