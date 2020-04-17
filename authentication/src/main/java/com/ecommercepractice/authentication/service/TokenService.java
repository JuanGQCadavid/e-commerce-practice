package com.ecommercepractice.authentication.service;

import com.ecommercepractice.authentication.dao.TokenDao;
import com.ecommercepractice.authentication.exception.ExpiredUserTokenException;
import com.ecommercepractice.authentication.exception.InvalidUserTokenException;
import com.ecommercepractice.authentication.exception.TokenNotFoundException;
import com.ecommercepractice.authentication.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Service
public class TokenService {
    @Autowired
    TokenDao tokenDao;

    private final int THREE_MONTHS = 3;

    /**
     * Remove token from repository
     * @param tokenId
     */
    public void removeToken(String tokenId){
        tokenDao.deleteToken(tokenId);
    }

    /**
     * Generate a 3-month token pass.
     * @return
     */
    public TokenModel tokenFor3Months(){
        LocalDate now = LocalDate.now();

        // Missing error at creating
        return  tokenDao.createToken(new TokenModel(now, now.plusMonths(THREE_MONTHS)))
                .get();
    }

    public boolean isValid(LocalDate expiredDate){
        LocalDate today = LocalDate.now();
        return expiredDate.isAfter(today) || expiredDate.isEqual(today);
    }

    /**
     * Checks if the token exists, then it validates its time alive.
     * @param tokenId
     * @return
     */
    public boolean validateToken(String tokenId){
        TokenModel actualToken = tokenDao.findToken(tokenId)
                .orElseThrow(() ->{
                            return new TokenNotFoundException(tokenId);
                        }
                );
        LocalDate today = LocalDate.now();

        if(actualToken.getExpiredDate().isAfter(today) || actualToken.getExpiredDate().isEqual(today)){
            return true;
        }
        else{
            throw new ExpiredUserTokenException(tokenId,actualToken.getExpiredDate());
        }

    }
}
