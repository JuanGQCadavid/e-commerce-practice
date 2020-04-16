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

    /**
     * Fetch an Auth by its email
     * @param email
     * @return Optional<AuthenticationModel> found auth
     */
    public Optional<AuthenticationModel> findByUserEmail(String email){
        return authenticationRepository.findByUserEmail(email);
    }

    /**
     * Store a user on the database
     * @param newAuth
     * @return Optional<AuthenticationModel> stored user
     */
    public Optional<AuthenticationModel> save(AuthenticationModel newAuth){
        return Optional.ofNullable(authenticationRepository.save(newAuth));
    }

    /**
     * Fetch an Auth by its id
     * @param userId
     * @return Optional<AuthenticationModel>
     */
    public Optional<AuthenticationModel> findById(String userId){
        return authenticationRepository.findById(userId);
    }

    /**
     * Fetch an Auth by its Token id
     * @param idToken
     * @return Optional<AuthenticationModel>
     */
    public Optional<AuthenticationModel> findByIdToken (String idToken){
        return authenticationRepository.findByIdToken(idToken);
    }

}
