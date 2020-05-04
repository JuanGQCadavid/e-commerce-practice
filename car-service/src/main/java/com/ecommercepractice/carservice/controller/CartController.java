package com.ecommercepractice.carservice.controller;

import com.ecommercepractice.carservice.model.CartWithProductsAssembler;
import com.ecommercepractice.carservice.model.CartWithProductsList;
import com.ecommercepractice.carservice.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/api/v1/cart")
@Api( value = "Cart's system" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {
    @Autowired
    CartService cartService;

    @ApiOperation(value = "DISABLE CART",notes = "Disable a cart, making its isActive flag becoming false")
    @DeleteMapping("/{idCart}")
    public ResponseEntity disableCart(@PathVariable Integer idCart){
        log.info(String.format("CART | DELETE | DISABLE_CART | PATH VARIABLE idCart -> %d",idCart));
        cartService.disableCart(idCart);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "FETCH CART BY idCart",notes = "Fetches Cart's info containing all products")
    @GetMapping("/{idCart}")
    public ResponseEntity<CartWithProductsAssembler> fetchByIdCart(@PathVariable Integer idCart){
        log.info(String.format("CART | GET | FETCH_BY_ID_CART | PATH VARIABLE idCart -> %d",idCart));
        return new ResponseEntity(new CartWithProductsAssembler(cartService.fetchByIdCart(idCart)), HttpStatus.OK);
    }

    /**
     * Fetch a cart
     * @param idUser
     */
    @ApiOperation(value = "CREATE / FETCH ACTUAL CART", notes = "If there is an actual cart related to the users, them the system" +
            "should return it, if not a new cart would be created instead.")
    @PostMapping("/{idUser}/fetch")
    public ResponseEntity<CartWithProductsAssembler> fetchActiveCart(@PathVariable Long idUser){
        log.info(String.format("CART | POST | FETCH_ACTIVE | PATH VARIABLE idUser -> %d",idUser));
        return new ResponseEntity(new CartWithProductsAssembler(cartService.fetchActiveCart(idUser)), HttpStatus.OK);
    }

    @ApiOperation(value = "APPEND A PRODUCT TO CART", notes ="Put a product onto the product's cart's list")
    @PostMapping("/{idCart}/append")
    public ResponseEntity appendProductToCart(@PathVariable(required = true) Integer idCart,
                                                                    @RequestParam(required = true) Integer idProductStock,
                                                                    @RequestParam(required = true) Integer quantity){
        log.info(String.format("CART | POST | APPEND_TO_CART | PATH VARIABLE idCart -> %d QUERY PARAMS productId-> %d quantity-> %d",idCart, idProductStock, quantity));
        cartService.appendProductToCart(idCart, idProductStock, quantity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "UPDATE A PRODUCT", notes = "Update an existing product in the product's cart's list")
    @PutMapping("/{idCart}/change")
    public ResponseEntity updateProductToCart(@PathVariable(required = true) Integer idCart,
                                              @RequestParam(required = true) Integer idProductStock,
                                              @RequestParam(required = true) Integer quantity){
        log.info(String.format("CART | PUT | CHANGE | PATH VARIABLE idCart -> %d QUERY PARAMS productId-> %d quantity-> %d",idCart, idProductStock, quantity));
        cartService.updateProductToCart(idCart, idProductStock, quantity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "REMOVE PRODUCT", notes = "Delete a product from the product's cart's list")
    @DeleteMapping("/{idCart}/remove")
    public ResponseEntity removeProduct(@PathVariable(required = true) Integer idCart, @RequestParam(required = true)Integer idProductStock){
        log.info(String.format("CART | DELETE | REMOVE | PATH VARIABLE idCart -> %d QUERY PARAMS productId-> %d ",idCart, idProductStock));
        cartService.removeProduct(idCart,idProductStock);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "SAVE CART", notes = "Save the actual's cart.")
    @PostMapping("/{idCart}/saved")
    public ResponseEntity saveCart(@PathVariable Integer idCart){
        log.info(String.format("CART | POST | SAVE_CART | PATH VARIABLE idCart -> %d",idCart));
        cartService.saveCart(idCart);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value="UNSAVED CART", notes = "Remove the cart from the saved carts")
    @DeleteMapping("/{idCart}/saved")
    public ResponseEntity removeSavedCart(@PathVariable Integer idCart){
        log.info(String.format("CART | DELETE | REMOVE_SAVED_CART | PATH VARIABLE idCart -> %d",idCart));
        cartService.removeSaveCart(idCart);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "GET ALL", notes = "FETCH ALL CARTS ACTIVE OR NOT ACTIVE.")
    @GetMapping()
    public ResponseEntity<List<CartWithProductsAssembler>> getAll(){
        log.info(String.format("CART | GET | GET_ALL"));
        List<CartWithProductsAssembler> carts = cartService.getAll()
                .stream()
                .map(cartWithProductsList -> {return new CartWithProductsAssembler(cartWithProductsList);})
                .collect(Collectors.toList());
        return new ResponseEntity(carts, HttpStatus.OK);
    }

}
