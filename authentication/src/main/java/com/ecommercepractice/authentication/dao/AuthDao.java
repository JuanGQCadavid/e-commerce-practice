package com.ecommercepractice.authentication.dao;

import com.ecommercepractice.authentication.model.AuthenticationModel;
import com.ecommercepractice.authentication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthDao {
    @Autowired
    AuthenticationRepository authenticationRepository;

    public Optional<AuthenticationModel> findByUserEmail(String email){
        return authenticationRepository.findByUserEmail(email);
    }

    public Optional<AuthenticationModel> save(AuthenticationModel newAuth){
        return Optional.ofNullable(authenticationRepository.save(newAuth));
    }

    public Optional<AuthenticationModel> findById(String userId){
        return authenticationRepository.findById(userId);
    }

}
