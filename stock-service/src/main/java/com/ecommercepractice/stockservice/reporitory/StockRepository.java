package com.ecommercepractice.stockservice.reporitory;

import com.ecommercepractice.stockservice.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    @Query("SELECT s FROM Stock s WHERE s.idProduct = ?1 AND s.isActive = true")
    Stock findActiveProductById(Long productId);

    /**
     * Fetch all Stock with price less than requested
     * by lessThanPrice
     * @param lessThanPrice
     * @return
     */
    @Query("SELECT s FROM Stock s WHERE s.salePrice < ?1")
    List<Stock> fetchAllStockProductsByPrice(double lessThanPrice);

    /**
     * Fetch all Active Stock with price less than requested
     * by lessThanPrice
     * @param lessThanPrice
     * @return
     */
    @Query("SELECT s FROM Stock s WHERE s.salePrice < ?1 AND s.isActive = true")
    List<Stock> fetchActiveStockProductsByPrice(double lessThanPrice);

    /**
     * Fetch all Active Stock products, return it inside a List<Product>
     * @return
     */
    @Query("SELECT s FROM Stock s WHERE s.isActive = true")
    List<Stock> fetchAllActiveStockProducts();

    /**
     * Fetch all Stock products, return it inside a List<Product>
     * @return
     */
    @Query("SELECT s FROM Stock s")
    List<Stock> fetchAllStockProducts();
}
