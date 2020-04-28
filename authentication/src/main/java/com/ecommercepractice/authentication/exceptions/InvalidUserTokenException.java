package com.ecommercepractice.authentication.exceptions;
import com.ecommercepractice.authentication.util.Pair;

/**
 * The token exist, but it is not attached to the current email.
 */

public class InvalidUserTokenException extends AuthException {
    public InvalidUserTokenException(String userEmail, String token){
        super(String.format("Invalid token { %s } for userEmail { %s } ", token,userEmail),new Pair<>(userEmail,token),ErrorType.INVALID_TOKEN);
    }
}
