package com.ecommercepractice.carservice.model;

import com.ecommercepractice.carservice.controller.CartModelAssembler;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.EntityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class CartWithProductsAssembler {
    private EntityModel<Cart> cart;

    private List<EntityModel<ProductList>> productList;

    public CartWithProductsAssembler(CartWithProductsList cartWithProductsList){
        this.cart = CartModelAssembler.toModelCart(cartWithProductsList.getCart());
        this.productList = cartWithProductsList.getProductList() == null ? new ArrayList<>() : cartWithProductsList
                .getProductList()
                .stream()
                .map(innerProductList -> { return  CartModelAssembler.toModelProduct(cartWithProductsList.getCart().getIdCart(),
                        innerProductList);})
                .collect(Collectors.toList());
    }

}
