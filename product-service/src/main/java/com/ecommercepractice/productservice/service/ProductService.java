package com.ecommercepractice.productservice.service;

import com.ecommercepractice.productservice.exception.ProductNotCreatedException;
import com.ecommercepractice.productservice.exception.ProductNotFoundedException;
import com.ecommercepractice.productservice.model.Product;
import com.ecommercepractice.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product productToCreate){
        if (productToCreate.getPhotoUrl() == null){
            productToCreate.setPhotoUrl("http://imgs.com/default.png");
        }

        Optional<Product> optionalProduct =
                Optional.ofNullable(productRepository.save(productToCreate));
        return optionalProduct
                .orElseThrow( () -> new  ProductNotCreatedException(productToCreate));
    }

    public Product fetchById(long productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundedException(productId));
    }

    public void deleteById(long productId){
        Product checkedProduct = fetchById(productId);
        productRepository.delete(checkedProduct);
    }

    public Product updateProduct(long productId, Product product){
        Product checkedProduct = fetchById(productId);
        // Talk with carlos
        checkedProduct.setName(product.getName());
        checkedProduct.setDescription(product.getDescription());
        checkedProduct.setPhotoUrl(product.getPhotoUrl());
        checkedProduct.setPrice(product.getPrice());

        return createProduct(checkedProduct);
    }

    public List<Product> filterProducts (Optional<String> name,
                                         Optional<Double> price){

        List<Product> productsToFilter = price.isPresent() ?
                productRepository.fetchProductsByPrice(price.get()) :
                productRepository.fetchAllProducts();

        return productsToFilter;
    }
}
