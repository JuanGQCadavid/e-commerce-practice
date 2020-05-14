package com.ecommercepractice.stockservice.controller;

import com.ecommercepractice.stockservice.model.FilterDTO;
import com.ecommercepractice.stockservice.model.Stock;
import com.ecommercepractice.stockservice.service.StockService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

import javax.ws.rs.BeanParam;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/api/v1/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @Autowired
    StockModelAssembler stockModelAssembler;

    @ApiOperation(value = "APPEND_TO_STOCK", notes = "Append a product to stock")
    @PostMapping("/products")
    public ResponseEntity<EntityModel<Stock>> appendToInventory(@Valid @RequestBody Stock productStock) {
        log.info(String.format("STOCK | APPEND | PAYLOAD { Stock -> %s } ", productStock));
        Stock stockAppended = stockService.appendToInventory(productStock);
        return new ResponseEntity(stockModelAssembler.toModel(stockAppended), HttpStatus.CREATED);
    }

    @ApiOperation(value ="FILTER", notes = "Fetch products by filtering them by price, stockQuantity and soldQuiantity" +
            "Also, you can specify whether you want to list not onlyProducts also")
    @GetMapping("/products/filter")
    public ResponseEntity<List<EntityModel<Stock>>> fetchByFiltering(@BeanParam FilterDTO filterDTO) {
        log.info(String.format("STOCK | FETCH | STOCK NAME -> { %s } PRICE -> { %s }  ",
                filterDTO.getPrice() == null ? "NO_PRICE" : filterDTO.getPrice().toString(),
                filterDTO.getStockQuantity() == null ? "NO_stockQuantity" : filterDTO.getStockQuantity().toString(),
                filterDTO.getSoldQuantity() == null ? "NO_soldQuantity" : filterDTO.getSoldQuantity().toString()));

        List<EntityModel<Stock>> stockList = stockService.fetchByFiltering(filterDTO.getPrice(), filterDTO.getStockQuantity(),
                filterDTO.getSoldQuantity(), filterDTO.getOnlyActive())
                .stream()
                .map(stockModelAssembler::toModel)
                .collect(Collectors.toList());

        return new ResponseEntity(stockList, HttpStatus.OK);
    }

    @ApiOperation(value ="FETCH BY ID", notes = "Get a product on stock by their id.")
    @GetMapping("/products/{stockId}")
    public ResponseEntity<EntityModel<Stock>> fetchByStockId(@PathVariable(required = true) Long stockId) {
        log.info(String.format("STOCK | FETCH | PAYLOAD { StockId -> %s } ", stockId));
        return new ResponseEntity(stockModelAssembler.toModel(stockService.fetchByStockId(stockId)), HttpStatus.OK);
    }

    @ApiOperation(value ="UPDATE BY ID", notes = "Update stockQuantity and/or salePrice on stock by their id.")
    @PutMapping("products/{stockId}")
    public ResponseEntity<EntityModel<Stock>> updateByStockId(@PathVariable(required = true) Long stockId,
                                                 @RequestParam(required = false) Long stockQuantity,
                                                 @RequestParam(required = false) Float salePrice
    ) {
        log.info(String.format("STOCK | UPDATE | PAYLOAD { StockId -> %s , Stock -> %s } ", stockId,
                stockQuantity == null ? "NO_QUANTITY" : stockQuantity,
                salePrice == null ? "NO_SALE_PRICE" : salePrice
        ));
        return new ResponseEntity(stockModelAssembler.toModel(stockService.updateByStockId(stockId, stockQuantity, salePrice)), HttpStatus.OK);
    }
    @ApiOperation(value ="DELETE BY ID", notes = "DELETE a product on stock by their id.")
    @DeleteMapping("products/{stockId}")
    public ResponseEntity deleteByStockId(@PathVariable(required = true) Long stockId) {
        log.info(String.format("STOCK | DELETE | PAYLOAD { StockId -> %s } ", stockId));
        stockService.deleteByStockId(stockId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value ="FREEZE BY ID", notes = "FREEZE a product on stock by their id. When a product is freezed means" +
            "that is inside a car.")
    @PostMapping("products/{stockId}/freeze/{freezeQuantities}")
    public ResponseEntity freezeStockItem(@PathVariable(required = true) Long stockId, @PathVariable(required = true) Long freezeQuantities) {
        log.info(String.format("STOCK | FREEZE | PAYLOAD { StockId -> %s} ", stockId));
        stockService.freezeStockItem(stockId, freezeQuantities);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value ="BOUGHT BY ID", notes = "BOUGHT a product on stock by their id. That means, the product is" +
            "already paid, and it is not available for being purchased")
    @PostMapping("products/{stockId}/buy/{QuantityToBuy}")
    public ResponseEntity boughtStockItem(@PathVariable(required = true) Long stockId, @PathVariable Long QuantityToBuy) {
        log.info(String.format("STOCK | BOUGHT | PAYLOAD { StockId -> %s } ", stockId));
        stockService.boughtStockItem(stockId, QuantityToBuy);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}