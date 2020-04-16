package com.ecommercepractice.authentication.exception;

import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The token exist, but it is not attached to the current email.
 */
@Getter
@Slf4j
public class InvalidUserTokenException extends RuntimeException {
    Pair<String, String> payload;

    public InvalidUserTokenException(String userEmail, String token){
        super(String.format("Invalid token { %s } for userEmail { %s } ", token,userEmail));
        log.error(this.getMessage());
        payload = new Pair<>(userEmail,token);
    }
}
