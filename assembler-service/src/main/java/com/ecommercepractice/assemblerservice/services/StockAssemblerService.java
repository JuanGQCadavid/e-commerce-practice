package com.ecommercepractice.assemblerservice.services;

import com.ecommercepractice.assemblerservice.clients.ProductsServices;
import com.ecommercepractice.assemblerservice.clients.StockServices;
import com.ecommercepractice.assemblerservice.models.assemblerModels.StockProductDTO;
import com.ecommercepractice.assemblerservice.models.productModels.response.Product;
import com.ecommercepractice.assemblerservice.models.stockModels.response.StockProduct;
import com.ecommercepractice.assemblerservice.services.mappers.StockAssemblerMappers;
import com.ecommercepractice.utilities.util.Pair;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockAssemblerService {
    @Autowired
    private StockAssemblerMappers mappers;

    @Autowired
    private ProductsServices productsServices;

    @Autowired
    private StockServices stockServices;

    public List<StockProductDTO> fetchStockProducts() {
        return stockServices.filterProducts()
                .map(entityModels -> castStockProducts(entityModels))
                .blockingFirst();
    }

    public List<StockProductDTO> fetchFilteredStockProducts(Float price, Long stockQuantity, Long soldQuantity, Boolean onlyActive) {
        return stockServices.filterProducts(price,stockQuantity,soldQuantity,onlyActive)
                .map(entityModels -> castStockProducts(entityModels))
                .blockingFirst();
    }


    public List<StockProductDTO> castStockProducts(List<EntityModel<StockProduct>> stockProducts){
        return stockProducts.stream()
                .map(EntityModel::getContent)
                .map(stockProduct -> new Pair<Product,StockProduct>(fetchProductInfo(stockProduct.getIdProduct()),
                        stockProduct ))
                .filter(pair -> pair.getKey().getIdProduct() >= 0)
                .map(productStockProductPair -> mappers.castToProductDTO(productStockProductPair.getKey(),
                        productStockProductPair.getValue()))

                .collect(Collectors.toList());
    }

    public Product fetchProductInfo(long idProduct){
        return productsServices.fetchProductById(idProduct)
                .map(productEntityModel -> productEntityModel.getContent())
                .onErrorReturnItem(mappers.noProduct(idProduct))
                .blockingFirst();
    }
}
