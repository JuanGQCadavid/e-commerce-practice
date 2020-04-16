package com.ecommercepractice.productservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductServiceController {

    @PostMapping()
    public void createProduct(){

    }

    @GetMapping()
    public void fetchProduct(
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) long price
    ){
        System.out.println(tags);
        System.out.println(name);
        System.out.println(price);
    }


    //:ProductId
    @GetMapping("/{productId}")
    public void fetchProductById(
            @PathVariable String productId
    ){
        System.out.println(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(
            @PathVariable String productId
    ){
        System.out.println(productId);
    }

    @PutMapping("/{productId}")
    public void updateProductById(
            @PathVariable String productId
    ){
        System.out.println(productId);
    }
}
