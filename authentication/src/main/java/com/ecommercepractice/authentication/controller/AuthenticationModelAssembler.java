package com.ecommercepractice.authentication.controller;


import com.ecommercepractice.authentication.model.AuthMobile;
import com.ecommercepractice.authentication.model.AuthenticationModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AuthenticationModelAssembler {
    public EntityModel<AuthenticationModel> toModelRegister(AuthenticationModel authentication){
        AuthMobile authMobile = new AuthMobile();
        authMobile.setUserInfo(authentication);

        return new EntityModel<AuthenticationModel>(authentication,
                linkTo(methodOn(AuthenticationController.class)
                        .logIn(authMobile)).withRel("LOG_IN"),
                linkTo(methodOn(AuthenticationController.class)
                        .logOut(authentication.getIdToken())).withRel("LOG_OUT"),
                linkTo(methodOn(AuthenticationController.class)
                        .validateToken(authentication.getUserEmail(),authentication.getIdToken())).withRel("VALIDATE_TOKEN")

                );
    }

    public EntityModel<AuthenticationModel> toModelLogIn(AuthenticationModel authentication){
        AuthMobile authMobile = new AuthMobile();
        authMobile.setUserInfo(authentication);

        return new EntityModel<AuthenticationModel>(authentication,
                linkTo(methodOn(AuthenticationController.class)
                        .logOut(authentication.getIdToken())).withRel("LOG_OUT"),
                linkTo(methodOn(AuthenticationController.class)
                        .validateToken(authentication.getUserEmail(),authentication.getIdToken())).withRel("VALIDATE_TOKEN")

        );
    }
}
