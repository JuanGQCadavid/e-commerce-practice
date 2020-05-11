package com.ecommercepractice.carservice.controller;

import com.ecommercepractice.carservice.model.Cart;
import com.ecommercepractice.carservice.model.CartWithProductsList;
import com.ecommercepractice.carservice.model.ProductList;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CartModelAssembler {
    /**
     * Creates links to methods that user could use
     * after the calling of a created nor fetch function
     * @return
     */
    public static EntityModel<Cart> toModelCart(Cart cart){
        return new EntityModel<>(cart,
                linkTo(methodOn(CartController.class)
                        .disableCart(cart.getIdCart(),false)).withRel("DISABLE CART"),
                linkTo(methodOn(CartController.class)
                        .fetchByIdCart(cart.getIdCart())).withRel("FETCH CART BY ID"),
                linkTo(methodOn(CartController.class)
                        .fetchActiveCart(cart.getIdUser())).withRel("FETCH CART BY USER ID"),
                linkTo(methodOn(CartController.class)
                        .saveCart(cart.getIdCart())).withRel("SAVE CART"),
                linkTo(methodOn(CartController.class)
                        .removeSavedCart(cart.getIdCart())).withRel("UNSAVE CART")
        );
    }

    public static EntityModel<ProductList> toModelProduct(Integer cartId, ProductList productsList){
        return new EntityModel(productsList,
                linkTo(methodOn(CartController.class)
                        .appendProductToCart(cartId,productsList.getProductListId().getIdProductStock(), productsList.getQuantity())).withRel("APPEND PRODUCT"),
                linkTo(methodOn(CartController.class)
                        .updateProductToCart(cartId,productsList.getProductListId().getIdProductStock(), productsList.getQuantity())).withRel("UPDATE PRODUCT"),
                linkTo(methodOn(CartController.class)
                        .removeProduct(cartId,productsList.getProductListId().getIdProductStock())).withRel("REMOVE PRODUCT")
                );
    }
}