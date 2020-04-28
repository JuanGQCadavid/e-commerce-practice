package com.ecommercepractice.authentication.repository;

import com.ecommercepractice.authentication.model.TokenModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<TokenModel, String> {
    void deleteByTokenId(String tokenId);
}
