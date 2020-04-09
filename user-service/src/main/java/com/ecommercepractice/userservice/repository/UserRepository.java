package com.ecommercepractice.userservice.repository;


import com.ecommercepractice.userservice.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<List<User> >findByFirstName(String firstName);
    List<User> findAll();
    Optional<User> findByEmail(String email);
}
