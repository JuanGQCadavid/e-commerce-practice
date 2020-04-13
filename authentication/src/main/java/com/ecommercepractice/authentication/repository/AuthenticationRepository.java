package com.ecommercepractice.authentication.repository;

import com.ecommercepractice.authentication.model.AuthenticationModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthenticationRepository extends CrudRepository<AuthenticationModel, String> {
    Optional<AuthenticationModel> findByUserEmail(String userEmail);
}
