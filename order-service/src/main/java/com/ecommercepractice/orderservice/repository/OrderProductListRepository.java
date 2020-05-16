package com.ecommercepractice.orderservice.repository;

import com.ecommercepractice.orderservice.model.OrderProductList;
import com.ecommercepractice.orderservice.model.OrderProductListId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductListRepository extends CrudRepository<OrderProductList, OrderProductListId> {

    @Query("SELECT COUNT ( DISTINCT orderList.orderProductListId.orderProductListUniqueId ) FROM OrderProductList orderList ")
    Integer uniqueIdCounter();

    default Integer nextUniqueId(){
        return uniqueIdCounter() + 1;
    }

    @Query("SELECT orderList FROM OrderProductList orderList WHERE orderList.orderProductListId.orderProductListUniqueId = ?1")
    List<OrderProductList> findAllByOrderProductListUniqueId(Integer orderProductListUniqueId);
}
