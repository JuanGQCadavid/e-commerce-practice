package com.ecommercepractice.carservice.repository;

import com.ecommercepractice.carservice.model.ProductList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductListRepository extends CrudRepository<ProductList,Integer> {

    @Query("SELECT p FROM ProductList p WHERE p.productListId.idProductList = ?1")
    Optional<List<ProductList>> fetchAllProductsWithIdProductList(Integer idProductList);

    @Query("SELECT p FROM ProductList p WHERE p.productListId.idProductList = ?1 AND p.productListId.idProductStock = ?2")
    Optional<ProductList> fetchProductListByProductId(Integer idProductList, Integer productId);

    default Integer nextProductListId(){
        Integer max = this.maxId();
        return max == null ? 0 : max + 1;
    }

    @Query("SELECT MAX (p.productListId.idProductList) FROM ProductList p")
    Integer maxId();

    @Query("SELECT p FROM ProductList p WHERE p.productListId.idProductList = ?1")
    List<ProductList> getAll(Integer idProductList);

    @Query("SELECT COUNT(p) FROM ProductList p WHERE p.productListId.idProductList = ?1")
    Integer countId(Integer idProductList);

}
