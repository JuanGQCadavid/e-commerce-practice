package com.ecommercepractice.authentication.exceptions;
import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;

/**
 * The token exist, but it is not attached to the current email.
 */
@Getter
public class InvalidUserTokenException extends RuntimeException {
    Pair<String, String> payload;
    public InvalidUserTokenException(String userEmail, String token){
        super(String.format("Invalid token { %s } for userEmail { %s } ", token,userEmail));
        payload = new Pair<>(userEmail,token);
    }
}
