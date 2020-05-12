package com.ecommercepractice.orderservice.repository;

import com.ecommercepractice.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAll();
}
