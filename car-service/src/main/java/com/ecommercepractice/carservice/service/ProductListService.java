package com.ecommercepractice.carservice.service;

import com.ecommercepractice.carservice.exception.ProductIdAlreadyInProductListException;
import com.ecommercepractice.carservice.exception.ProductIdNotFoundedException;
import com.ecommercepractice.carservice.exception.ProductListNotFoundedException;
import com.ecommercepractice.carservice.model.ProductList;
import com.ecommercepractice.carservice.model.ProductListId;
import com.ecommercepractice.carservice.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductListService {
    @Autowired
    ProductListRepository productListRepository;

    /**
     * Fetch all products associated to a product list Id
     * @param idProductList
     * @return
     */
    public List<ProductList> fetchById(Integer idProductList){
        return productListRepository.fetchAllProductsWithIdProductList(idProductList)
                .orElseThrow(() -> new  ProductListNotFoundedException(idProductList));
    }

    /**
     * Add a product to a list
     * @param idProductList
     * @param productId
     * @param quantity
     */
    public void appendProduct(Integer idProductList, Integer productId, Integer quantity){
        productListRepository.fetchProductListByProductId(idProductList,productId)
                .ifPresent(productList -> {
                    throw new ProductIdAlreadyInProductListException(idProductList, productId);
                });
        productListRepository.save( new ProductList( new ProductListId(idProductList, productId), quantity));

    }

    /**
     * Create a list and append a product
     * @param productId
     * @param quantity
     * @return
     */
    public Integer createAndAppend(Integer productId, Integer quantity) {
        Integer futureIdProductList = productListRepository.nextProductListId();
        return productListRepository.save(new ProductList(new ProductListId(futureIdProductList,productId ), quantity))
                .getProductListId()
                .getIdProductList();
    }

    /**
     * Get a product on the list.
     * @param idProductList
     * @param idProductStock
     * @return
     */
    public ProductList getProduct(Integer idProductList, Integer idProductStock){
        return productListRepository.fetchProductListByProductId(idProductList,idProductStock)
                .orElseThrow(() -> new ProductIdNotFoundedException(idProductList,idProductStock));
    }

    /**
     * Update a specified product inside the products list identified by their id.
     * @param idProductList
     * @param idProductStock
     * @param quantity
     */
    public void updateProduct(Integer idProductList, Integer idProductStock, Integer quantity) {
        ProductList productList = getProduct(idProductList, idProductStock);
        productList.setQuantity(quantity);
        productListRepository.save(productList);
    }

    /**
     * Remove a specified product inside the products list identified by their id.
     * @param idProductList
     * @param idProductStock
     */
    public void removeProduct(Integer idProductList, Integer idProductStock) {
        ProductList productList = getProduct(idProductList, idProductStock);
        productListRepository.delete(productList);
    }

    public Integer checkQuantity(Integer idProductList){
        return productListRepository.countId(idProductList);
    }

    /**
     * Fetch all products associated to a product list.
     * @param idProductList
     * @return
     */
    public List<ProductList> getAll(Integer idProductList) {
        return productListRepository.getAll(idProductList);
    }
}
