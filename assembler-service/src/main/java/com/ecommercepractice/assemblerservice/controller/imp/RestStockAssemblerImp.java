package com.ecommercepractice.assemblerservice.controller.imp;

import com.ecommercepractice.assemblerservice.controller.RestStockAssembler;
import com.ecommercepractice.assemblerservice.models.assemblerModels.StockProductDTO;
import com.ecommercepractice.assemblerservice.services.StockAssemblerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class RestStockAssemblerImp implements RestStockAssembler {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private StockAssemblerService stockAssemblerService;

    @Override
    public ResponseEntity<List<StockProductDTO>> fetchAll() {
        log.info(String.format(" %s | STOCK | FETCH ALL", appName));
        List<StockProductDTO> stockProducts = stockAssemblerService.fetchStockProducts();
        return new ResponseEntity(stockProducts, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StockProductDTO>> filterProducts(Float price, Long stockQuantity,
                                                                Long soldQuantity, Boolean onlyActive) {
        log.info(String.format(" %s | STOCK | FILTER", appName));
        List<StockProductDTO> stockProducts = stockAssemblerService.fetchFilteredStockProducts(price,stockQuantity,
                soldQuantity, onlyActive);
        return new ResponseEntity(stockProducts,HttpStatus.OK);
    }
}
