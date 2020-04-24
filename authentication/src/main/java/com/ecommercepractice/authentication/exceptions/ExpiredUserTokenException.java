package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;
import java.time.LocalDate;

/**
 * The token of Auth has is already expired
 */
@Getter
public class ExpiredUserTokenException extends RuntimeException {
    Pair<String, LocalDate> payload;
    public ExpiredUserTokenException(String tokenId, LocalDate tokenDate){
        super(String.format("Token has expired { %s } since { %s } ", tokenId,tokenDate));
        payload = new Pair<>(tokenId,tokenDate);
    }

}
