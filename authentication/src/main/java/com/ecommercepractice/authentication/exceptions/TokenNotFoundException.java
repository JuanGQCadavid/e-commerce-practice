package com.ecommercepractice.authentication.exceptions;
/**
 * Token does not exist on the database.
 */
public class TokenNotFoundException extends AuthException {
    public TokenNotFoundException(String token){
        super(String.format("Token { %s } does not exist.", token),token,ErrorType.TOKEN_NO_FOUND);
    }
}
