package com.ecommercepractice.authentication.service;

import com.ecommercepractice.authentication.dao.AuthDao;
import com.ecommercepractice.authentication.exception.EmailAlreadyUsedException;
import com.ecommercepractice.authentication.exception.EmailNotFoundException;
import com.ecommercepractice.authentication.exception.InvalidUserPasswordException;
import com.ecommercepractice.authentication.model.AuthenticationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthDao authDao;

    @Autowired
    TokenService tokenService;

    public AuthenticationModel login(AuthenticationModel authenticationModel){
        final String userEmail = authenticationModel.getUserEmail();
        final String userPassword = authenticationModel.getUserPassword();

        AuthenticationModel authUser = authDao.findByUserEmail(userEmail)
                .orElseThrow(() -> new EmailNotFoundException(userEmail));

        if ( authUser.getUserPassword().equals(userPassword) ){
            return authUser;
        } else {
            throw new InvalidUserPasswordException(userEmail,userPassword);
        }
    }

    public AuthenticationModel register( AuthenticationModel newAuthentication){
        authDao.findByUserEmail(newAuthentication.getUserEmail())
                .ifPresent( authenticationModel -> {throw new EmailAlreadyUsedException(newAuthentication.getUserEmail());});
        // Missing token // Missing check if it is saved.

        // Generate token

        newAuthentication.setIdToken(
                tokenService.tokenFor3Months()
                    .getTokenId()
        );

        return authDao.save(newAuthentication)
                .get();
    }
}
