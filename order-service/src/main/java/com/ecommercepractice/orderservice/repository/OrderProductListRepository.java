package com.ecommercepractice.orderservice.repository;

import com.ecommercepractice.orderservice.model.OrderProductListId;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductListRepository extends CrudRepository<OrderProductListRepository, OrderProductListId> {
    
}
