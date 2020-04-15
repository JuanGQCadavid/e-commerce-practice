package com.ecommercepractice.authentication.service;

import com.ecommercepractice.authentication.dao.TokenDao;
import com.ecommercepractice.authentication.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;


@Service
public class TokenService {
    @Autowired
    TokenDao tokenDao;

    private final int THREEMONTHS = 3;

    public TokenModel tokenFor3Months(){
        LocalDate now = LocalDate.now();

        // Missing error at creating
        return  tokenDao.createToken(new TokenModel(now, now.plusMonths(THREEMONTHS)))
                .get();
    }
}
