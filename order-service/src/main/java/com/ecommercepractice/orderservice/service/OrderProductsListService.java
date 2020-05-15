package com.ecommercepractice.orderservice.service;

import com.ecommercepractice.orderservice.model.OrderProductList;
import com.ecommercepractice.orderservice.model.OrderProductListId;
import com.ecommercepractice.orderservice.model.confirm.Product;
import com.ecommercepractice.orderservice.repository.OrderProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderProductsListService {
    @Autowired
    OrderProductListRepository orderProductListRepository;

    /**
     * Gives the next unique id for the
     * products list.
     * @return
     */
    public Integer getNextOrderProductListUniqueId(){
        return orderProductListRepository.nextUniqueId();
    }

    /**
     * Given a list of products, creates a OrderProductsList
     * for them
     * @param productList
     * @return
     */
    public Integer createListProducts(List<Product> productList) {
        Integer uniqueID = getNextOrderProductListUniqueId();

        List<OrderProductList> orderProductLists = productList
                .stream()
                .map( product -> {return new OrderProductList(
                        new OrderProductListId(uniqueID,product.getProductId()), product.getQuantity(), product.getPrice()
                );})
                .collect(Collectors.toList());

        orderProductListRepository.saveAll(orderProductLists);

        return uniqueID;
    }

    /**
     * get All products related to a unique Id
     * @param orderProductListUniqueId
     * @return
     */
    public List<OrderProductList> getProducts(Integer orderProductListUniqueId) {
        return orderProductListRepository.findAllByOrderProductListUniqueId(orderProductListUniqueId);
    }
}
