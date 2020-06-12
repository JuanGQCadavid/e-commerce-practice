package com.ecommercepractice.assemblerservice.controller;

import com.ecommercepractice.assemblerservice.models.assemblerModels.StockProductDTO;
import com.ecommercepractice.assemblerservice.models.stockModels.response.StockProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/assembler/stock")
public interface RestStockAssembler {

    @GetMapping("/")
    public ResponseEntity<List<StockProductDTO>> fetchAll();

    @GetMapping("/filter")
    public ResponseEntity<List<StockProductDTO>> filterProducts(@RequestParam(value = "price", required = false)
                                                                            Float price,
                                                                @RequestParam(value = "stockQuantity", required = false)
                                                                            Long stockQuantity,
                                                                @RequestParam(value = "soldQuantity", required = false)
                                                                            Long soldQuantity,
                                                                @RequestParam(value = "onlyActive",required = false, defaultValue = "true")
                                                                            Boolean onlyActive);

    @PostMapping("/")
    public ResponseEntity appendToStock(@Valid @RequestBody StockProduct stockProduct);

}
