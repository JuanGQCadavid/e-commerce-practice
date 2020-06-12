package com.ecommercepractice.assemblerservice.services.mappers;

import com.ecommercepractice.assemblerservice.models.assemblerModels.StockProductDTO;
import com.ecommercepractice.assemblerservice.models.productModels.response.Product;
import com.ecommercepractice.assemblerservice.models.stockModels.response.StockProduct;
import org.springframework.stereotype.Component;

@Component
public class StockAssemblerMappers {

    public Product noProduct(long idProduct) {
        return Product.builder()
                .description("No description.")
                .idProduct(-1)
                .name("No name.")
                .photoUrl("No photo.")
                .price(-1.0)
                .build();
    }

    public StockProductDTO castToProductDTO(Product product, StockProduct stockProduct) {
        return StockProductDTO.builder()
                .availableQuantity(calculateRemaining(stockProduct.getStockQuantity(),
                        stockProduct.getFreezeQuantity(),
                        stockProduct.getSoldQuantity()))
                .description(product.getDescription())
                .idInventory(stockProduct.getIdInventory())
                .name(product.getName())
                .photoUrl(product.getPhotoUrl())
                .salePrice(stockProduct.getSalePrice())
                .stockQuantity(stockProduct.getStockQuantity())
                .build();

    }

    private long calculateRemaining(Long stockQuantity, Long freezeQuantity, Long soldQuantity){
        return stockQuantity - (freezeQuantity + soldQuantity);
    }
}
