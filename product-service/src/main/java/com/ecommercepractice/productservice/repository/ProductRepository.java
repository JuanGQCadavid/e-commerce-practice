package com.ecommercepractice.productservice.repository;

import com.ecommercepractice.productservice.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> fetchProductsByPrice(double lessThanPrice);

    @Query("SELECT p FROM Product p")
    List<Product> fetchAllProducts();
}
