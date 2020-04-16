package com.ecommercepractice.authentication.dao;

import com.ecommercepractice.authentication.model.TokenModel;
import com.ecommercepractice.authentication.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenDao {
    @Autowired
    TokenRepository tokenRepository;

    /**
     * Register a token .
     * @param token
     * @return ptional<TokenModel>
     */
    public Optional<TokenModel> createToken( TokenModel token){
        return Optional.ofNullable(tokenRepository.save(token));
    }

    /**
     * Fetch a token by its Id
     *
     * @param tokenId
     * @return Optional<TokenModel>
     */
    public Optional<TokenModel> findToken(String tokenId){
        return tokenRepository.findById(tokenId);
    }

    /**
     * Removes the token from Database
     * @param tokenId
     */

    public void deleteToken(String tokenId){
        tokenRepository.deleteById(tokenId);
    }
}
