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
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    private final String DEFAULT_PHOTO = "http://imgs.com/default.png";

    /**
     * used the repository to create a new product,
     * if there is no image then it would assign a
     * default one.
     * @param productToCreate
     * @return
     */
    public Product createProduct(Product productToCreate){
        if (productToCreate.getPhotoUrl() == null){
            productToCreate.setPhotoUrl(DEFAULT_PHOTO);
        }

        Optional<Product> optionalProduct =
                Optional.ofNullable(productRepository.save(productToCreate));
        return optionalProduct
                .orElseThrow( () -> new  ProductNotCreatedException(productToCreate));
    }

    /**
     * Fetch a product by its Id, if there is no product
     * with such id; then, it must rise an error.
     * @param productId
     * @return
     */
    public Product fetchById(long productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundedException(productId));
    }

    /**
     * Check if the product exists, if so then remove it
     * from repository if not an error is raise from
     * fetchById() method
     * @param productId
     */
    public void deleteById(long productId){
        Product checkedProduct = fetchById(productId);
        productRepository.delete(checkedProduct);
    }
    /**
     * Check if the product exists, if so then update it
     * from repository if not an error is raise from
     * fetchById() method
     * @param productId
     */
    public Product updateProduct(long productId, Product product){
        Product checkedProduct = fetchById(productId);
        // Talk with carlos
        checkedProduct.setName(product.getName());
        checkedProduct.setDescription(product.getDescription());
        checkedProduct.setPhotoUrl(product.getPhotoUrl());
        checkedProduct.setPrice(product.getPrice());

        return createProduct(checkedProduct);
    }

    /**
     * Filter products by a given price
     *  (All of them if price is no specified) and then filter them by name
     *  (If name is no specified, then it returns all products after the first filter step).
     * @param name
     * @param price
     * @return
     */
    public List<Product> filterProducts (Optional<String> name,
                                         Optional<Double> price){

        List<Product> productsToFilter = price.isPresent() ?
                productRepository.fetchProductsByPrice(price.get()) :
                productRepository.fetchAllProducts();

        return name.isPresent() ? filterByName(name.get(),productsToFilter ) : productsToFilter;
    }

    /**
     * Fetches all products that their names contains
     * the product name requested.
     * @param name
     * @param products
     * @return
     */
    public List<Product> filterByName(String name, List<Product> products){
        return products
                .stream()
                .filter(product -> {
                    return product.getName().contains(name);
                })
                .collect(Collectors.toList());
    }
}
