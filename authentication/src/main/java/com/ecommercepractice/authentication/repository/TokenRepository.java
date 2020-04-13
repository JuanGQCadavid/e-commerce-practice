package com.ecommercepractice.authentication.repository;

import com.ecommercepractice.authentication.model.TokenModel;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<TokenModel, String> {
}
