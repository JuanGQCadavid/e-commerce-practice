package com.ecommercepractice.authentication.exceptions;
import lombok.Getter;
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
