package com.ecommercepractice.userservice.dao;


import com.ecommercepractice.userservice.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,String> {
    List<User> findByFirstName(String firstName);
}
