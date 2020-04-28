package com.ecommercepractice.authentication.repository;

import com.ecommercepractice.authentication.model.AuthenticationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends CrudRepository<AuthenticationModel, String> {
    Optional<AuthenticationModel> findByUserEmail(String userEmail);
    Optional<AuthenticationModel> findByIdToken (String idToken);
}
