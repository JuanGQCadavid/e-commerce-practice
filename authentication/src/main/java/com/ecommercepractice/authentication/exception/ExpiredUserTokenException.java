package com.ecommercepractice.authentication.exception;

import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * The token of Auth has is already expired
 */
@Getter
@Slf4j
public class ExpiredUserTokenException extends RuntimeException {
    Pair<String, LocalDate> payload;

    public ExpiredUserTokenException(String tokenId, LocalDate tokenDate){
        super(String.format("Token has expired { %s } since { %s } ", tokenId,tokenDate));
        log.error(this.getMessage());
        payload = new Pair<>(tokenId,tokenDate);
    }

}
