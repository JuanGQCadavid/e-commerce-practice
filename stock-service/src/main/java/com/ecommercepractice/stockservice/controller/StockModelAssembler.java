package com.ecommercepractice.stockservice.controller;

import com.ecommercepractice.stockservice.model.Stock;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Create links to methods that user could use
 * after the calling of a created nor fetch function
 */
@Component
public class StockModelAssembler {
    public EntityModel<Stock> toModel (Stock stock){
        return new EntityModel<Stock>(stock,
                linkTo(methodOn(StockController.class)
                        .fetchByFiltering(stock.getSalePrice(),stock.getStockQuantity(),stock.getSoldQuantity(), true)).withRel("FILTER"),
                linkTo(methodOn(StockController.class)
                        .fetchByStockId(stock.getIdInventory())).withRel("FETCH_BY_ID"),
                linkTo((methodOn(StockController.class)
                        .updateByStockId(stock.getIdInventory(),stock.getStockQuantity(),stock.getSalePrice()))).withRel("UPDATE"),
                linkTo(methodOn(StockController.class)
                        .deleteByStockId(stock.getIdInventory())).withRel("INACTIVE"),
                linkTo(methodOn(StockController.class)
                        .freezeStockItem(stock.getIdInventory(),1l)).withRel("FREEZE"),
                linkTo(methodOn(StockController.class)
                        .boughtStockItem(stock.getIdInventory(),1l)).withRel("BOUGHT")
                );
    }
}
