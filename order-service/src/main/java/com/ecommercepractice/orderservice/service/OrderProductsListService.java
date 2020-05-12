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

    public Integer getNextOrderProductListUniqueId(){
        return orderProductListRepository.nextUniqueId();
    }

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

    public List<OrderProductList> getProducts(Integer orderProductListUniqueId) {
        return orderProductListRepository.findAllByOrderProductListUniqueId(orderProductListUniqueId);
    }
}
