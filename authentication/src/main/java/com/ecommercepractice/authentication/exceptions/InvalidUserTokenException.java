package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

/**
 * The token exist, but it is not attached to the current email.
 */

public class InvalidUserTokenException extends GeneralException {
    public InvalidUserTokenException(String userEmail, String token){
        super(String.format("Invalid token { %s } for userEmail { %s } ", token,userEmail),
                ErrorType.INVALID_TOKEN.generateGeneral() , new Pair<>(userEmail,token));
    }
}
