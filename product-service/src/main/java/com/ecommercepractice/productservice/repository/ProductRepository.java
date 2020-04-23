package com.ecommercepractice.productservice.repository;

import com.ecommercepractice.productservice.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    /**
     * Fetch all products with price less than requested
     * by lessThanPrice
     * @param lessThanPrice
     * @return
     */
    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> fetchProductsByPrice(double lessThanPrice);

    /**
     * Fetch all products and return it inside a List<Product>
     * @return
     */
    @Query("SELECT p FROM Product p")
    List<Product> fetchAllProducts();
}
