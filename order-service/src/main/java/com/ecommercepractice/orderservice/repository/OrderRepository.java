package com.ecommercepractice.orderservice.repository;

import com.ecommercepractice.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
