package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

import java.time.LocalDate;

/**
 * The token of Auth has is already expired
 */
public class ExpiredUserTokenException extends GeneralException {
    public ExpiredUserTokenException(String tokenId, LocalDate tokenDate){
        super(String.format("Token has expired { %s } since { %s } ", tokenId,tokenDate),
                ErrorType.EXPIRED_TOKEN.generateGeneral(), new Pair<>(tokenId,tokenDate));
    }

}
