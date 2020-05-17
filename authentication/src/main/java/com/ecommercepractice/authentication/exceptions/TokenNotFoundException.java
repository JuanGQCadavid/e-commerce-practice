package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * Token does not exist on the database.
 */
public class TokenNotFoundException extends GeneralException {
    public TokenNotFoundException(String token){
        super(String.format("Token { %s } does not exist.", token),ErrorType.TOKEN_NO_FOUND.generateGeneral(),token);
    }
}
