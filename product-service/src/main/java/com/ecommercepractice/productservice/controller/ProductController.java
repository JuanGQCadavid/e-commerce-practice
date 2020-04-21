package com.ecommercepractice.productservice.controller;

import com.ecommercepractice.productservice.model.Product;
import com.ecommercepractice.productservice.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(value = "Products handler endpoints",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductModelAssembler productModelAssembler;

    @ApiOperation(value="CREATED PRODUCT", notes = "Receive product Object and store it on" +
            "the repository, it does not validate name repeated or any other field")
    @PostMapping()
    public ResponseEntity<EntityModel<Product>> createProduct(@Valid @RequestBody Product product){
        log.info(String.format("PRODUCT | CREATE | Product payload { %s }", product));
        return new ResponseEntity<EntityModel<Product>>(
                productModelAssembler.toModel(productService.createProduct(product)),
                HttpStatus.CREATED);
    }
    @ApiOperation(value ="FILTER BY NAME OR/AND PRICE ", notes = "Filter products by a given price" +
            " (All of them if price is no specified) and then filter them by name" +
            " ( If name is no specified, then it returns all products after the first filter step)")
    @GetMapping()
    public ResponseEntity<List<EntityModel<Product>>> fetchProduct(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price
    ){
        log.info(String.format("PRODUCT | FETCH | Product NAME -> { %s } PRICE -> { %s }",
                name==null ? "NO_NAME" : name ,
                price == null ?  "NO_PRICE" : price.toString()));
        List<Product> productsList = productService.filterProducts(name,price);
        List<EntityModel<Product>> entities = productsList
                .stream()
                .map(product -> productModelAssembler.toModel(product))
                .collect(Collectors.toList());
        return new ResponseEntity<>(
                entities,
                HttpStatus.OK
                );
    }
    //:ProductId
    @ApiOperation(value ="GET BY ID", notes = "Fetches products by their id")
    @GetMapping("/{productId}")
    public ResponseEntity<EntityModel<Product>> fetchProductById(@PathVariable Long productId){
        log.info(String.format("PRODUCT | FETCH_BY_ID | ProductId payload { %d }", productId));
        return new ResponseEntity<>(
                productModelAssembler.toModel(productService.fetchById(productId)),
                HttpStatus.OK);
    }
    @ApiOperation(value ="DELETE BY ID", notes = "Removes products by their id")
    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProductById(@PathVariable long productId){
        log.info(String.format("PRODUCT |DELETE_BY_ID | ProductId payload { %d }", productId));
        productService.deleteById(productId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Talk with Carlos
    @ApiOperation(value ="PUT BY ID", notes = "Update products by their id, Product is need" +
            " on body request.")
    @PutMapping("/{productId}")
    public ResponseEntity<EntityModel<Product>>  updateProductById(@PathVariable long productId,@Valid @RequestBody Product product){
        log.info(String.format("PRODUCT | PUT_BY_ID | ProductId { %d } Product dat { %s} ", productId,product));
        return new ResponseEntity(
                productModelAssembler.toModel(productService.updateProduct(productId,product)),
                HttpStatus.OK);
    }
}
