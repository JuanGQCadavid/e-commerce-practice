package com.ecommercepractice.authentication.service;

import com.ecommercepractice.authentication.dao.AuthDao;
import com.ecommercepractice.authentication.exception.*;
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
            // Put a Token on it
            authUser.setIdToken(
                    tokenService.tokenFor3Months()
                            .getTokenId()
            );

            return authDao.save(authUser)
                    .get();
        } else {
            throw new InvalidUserPasswordException(userEmail,userPassword);
        }
    }

    public AuthenticationModel register( AuthenticationModel newAuthentication){
        authDao.findByUserEmail(newAuthentication.getUserEmail())
                .ifPresent( authenticationModel -> {throw new EmailAlreadyUsedException(newAuthentication.getUserEmail());});

        // Missing check if it is saved.
        newAuthentication.setIdToken("NONE");

        return authDao.save(newAuthentication)
                .get();
    }

    // Should I talk to you or to DAO?
    public boolean validateAuth(String userEmail, String tokenId){
        // Lets check the user has the token associated.
        AuthenticationModel authentication = authDao.findByUserEmail(userEmail)
                .orElseThrow(() -> {
                    return new EmailNotFoundException(userEmail);
                });

        if (authentication.getIdToken().equals(tokenId)){
            return tokenService.validateToken(tokenId);
        }else{
            throw new InvalidUserTokenException(userEmail,tokenId);
        }
    }
}
