package com.ecommercepractice.authentication.service;

import com.ecommercepractice.authentication.dao.AuthDao;

import com.ecommercepractice.authentication.exceptions.EmailNotFoundException;
import com.ecommercepractice.authentication.exceptions.InvalidUserPasswordException;
import com.ecommercepractice.authentication.exceptions.TokenNotFoundException;
import com.ecommercepractice.authentication.exceptions.InvalidUserTokenException;
import com.ecommercepractice.authentication.exceptions.EmailAlreadyUsedException;

import com.ecommercepractice.authentication.model.AuthenticationModel;
import com.ecommercepractice.authentication.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    final String DEFAULT_NOT_TOKEN= "NONE";

    @Autowired
    AuthDao authDao;

    @Autowired
    TokenService tokenService;
    /**
     * Validate the email, then check the user credentials.
     * @param authenticationModel
     * @return
     */
    public TokenModel login(AuthenticationModel authenticationModel) {
        final String userEmail = authenticationModel.getUserEmail();
        final String userPassword = authenticationModel.getUserPassword();

        AuthenticationModel authUser = authDao.findByUserEmail(userEmail)
                .orElseThrow(() -> new EmailNotFoundException(userEmail));

        if (!authUser.getUserPassword().equals(userPassword)) {
            throw new InvalidUserPasswordException(userEmail, userPassword);
        }
        TokenModel newToken =  tokenService.tokenFor3Months();
        authUser.setIdToken(newToken.getTokenId());
        authDao.save(authUser).get();

        return newToken;
    }

    /**
     * Remove token from auth entity associated to the token,
     * then it removes the token from the entity.
     * @param tokenId
     */
    public void logout(String tokenId){
        AuthenticationModel authentication = authDao.findByIdToken(tokenId)
                .orElseThrow(() ->  new TokenNotFoundException(tokenId));
        authentication.setIdToken(DEFAULT_NOT_TOKEN);
        authDao.save(authentication);
        tokenService.removeToken(tokenId);
    }
    /**
     * Store the authentication on the repository
     * and assign a NONE token.
     * @param newAuthentication
     * @return
     */
    public AuthenticationModel register( AuthenticationModel newAuthentication){
        authDao.findByUserEmail(newAuthentication.getUserEmail())
                .ifPresent( authenticationModel -> {throw new EmailAlreadyUsedException(newAuthentication.getUserEmail());});
        newAuthentication.setIdToken(DEFAULT_NOT_TOKEN);
        return authDao.save(newAuthentication).get();
    }
    /**
     * Validate first the userEmail, then validates that the token
     * is arsing to the email.
     * @param userEmail
     * @param tokenId
     * @return
     */
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
