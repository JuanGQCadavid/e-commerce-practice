package com.ecommercepractice.authentication.exception;

import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Token does not exist on the database.
 */
@Getter
public class TokenNotFoundException extends RuntimeException {
    String payload;

    public TokenNotFoundException(String token){
        super(String.format("Token { %s } does not exist.", token));
        payload = token;
    }
}
