package com.ecommercepractice.authentication.controller;
import com.ecommercepractice.authentication.model.AuthenticationModel;
import com.ecommercepractice.authentication.model.TokenModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AuthenticationModelAssembler {
    /**
     * Create links response pointing to the methods allowed
     * by the api, indicating how can the request user proceed
     * across the API after the user register itself on the platform.
     * @param authentication
     * @return
     */
    public EntityModel<AuthenticationModel> toModelRegister(AuthenticationModel authentication){
        return new EntityModel<AuthenticationModel>(authentication,
                linkTo(methodOn(AuthenticationController.class).logIn(null)).withRel("LOG_IN"),
                linkTo(methodOn(AuthenticationController.class).logOut(null)).withRel("LOG_OUT"),
                linkTo(methodOn(AuthenticationController.class).validateToken(null,authentication.getUserEmail())).withRel("VALIDATE_TOKEN")
                );
    }
    /**
     * Create links response pointing to the methods allowed
     * by the api, indicating how can the request user proceed
     * across the API after the user identify itself on the platform.
     * @param authentication
     * @return
     */

    public EntityModel<TokenModel> toModelLogIn(AuthenticationModel authentication,
                                                         TokenModel token){
        return new EntityModel<TokenModel>(token,
                linkTo(methodOn(AuthenticationController.class).logOut(null)).withRel("LOG_OUT"),
                linkTo(methodOn(AuthenticationController.class).validateToken(null, authentication.getUserEmail())).withRel("VALIDATE_TOKEN")
        );
    }
}
