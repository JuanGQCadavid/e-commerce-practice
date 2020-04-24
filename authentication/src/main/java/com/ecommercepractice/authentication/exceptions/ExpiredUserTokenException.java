package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.authentication.util.Pair;
import java.time.LocalDate;

/**
 * The token of Auth has is already expired
 */
public class ExpiredUserTokenException extends AuthException {
    public ExpiredUserTokenException(String tokenId, LocalDate tokenDate){
        super(String.format("Token has expired { %s } since { %s } ", tokenId,tokenDate), new Pair<>(tokenId,tokenDate), ErrorType.EXPIRED_TOKEN);
    }

}
