package com.ecommercepractice.carservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartWithProductsList {
    @ApiModelProperty("Carts info")
    private Cart cart;

    @ApiModelProperty("Associated products to the cart")
    private List<ProductList> productList;


    public CartWithProductsList setCart(Cart cart){
        this.cart = cart;
        return this;
    }

    public CartWithProductsList setProductList(List<ProductList> productList){
        this.productList = productList;
        return this;
    }


}
