package com.ecommercepractice.orderservice.repository;

import com.ecommercepractice.orderservice.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

    List<Orders> findAll();

    List<Orders> findAllByUserId(Integer userId);
}
