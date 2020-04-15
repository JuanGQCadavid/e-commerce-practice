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

    public Optional<TokenModel> createToken( TokenModel token){
        return Optional.ofNullable(tokenRepository.save(token));
    }

    public Optional<TokenModel> findToken(String tokenId){
        return tokenRepository.findById(tokenId);
    }
}
