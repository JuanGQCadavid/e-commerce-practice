package com.ecommercepractice.productservice.controller;

import com.ecommercepractice.productservice.model.Product;
import com.ecommercepractice.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductServiceController {

    @Autowired
    ProductService productService;



    @PostMapping()
    public ResponseEntity<Product> createProduct(
           @Valid @RequestBody Product product
    ){
        log.info(String.format("PRODUCT | CREATE | Product payload { %s }", product));
        return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<List<Product>> fetchProduct(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price
    ){

        System.out.println(name);
        System.out.println(price);

        return new ResponseEntity<List<Product>>(
                productService.filterProducts(
                        Optional.ofNullable(name),
                        Optional.ofNullable(price)
                ),
                HttpStatus.OK
                );
    }




    //:ProductId
    @GetMapping("/{productId}")
    public ResponseEntity<Product> fetchProductById(
            @PathVariable Long productId
    ){
        log.info(String.format("PRODUCT | FETCH_BY_ID | ProductId payload { %d }", productId));
        return new ResponseEntity<Product>(productService.fetchById(productId), HttpStatus.OK);
    }
    //--- Under construction

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProductById(
            @PathVariable long productId
    ){
        log.info(String.format("PRODUCT |DELETE_BY_ID | ProductId payload { %d }", productId));
        productService.deleteById(productId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //--- Under construction

    // Talk with Carlos
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProductById(
            @PathVariable long productId,
            @RequestBody Product product
    ){
        log.info(String.format("PRODUCT | PUT_BY_ID | ProductId { %d } Product dat { %s} ", productId,product));
        return new ResponseEntity<Product>(productService.updateProduct(productId,product), HttpStatus.OK);
    }
}
