package com.ecommercepractice.userservice.dao;

import com.ecommercepractice.userservice.models.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoryTest extends CrudRepository<Customers,Long> {
    List<Customers> findByLastName(String lastName);
}
