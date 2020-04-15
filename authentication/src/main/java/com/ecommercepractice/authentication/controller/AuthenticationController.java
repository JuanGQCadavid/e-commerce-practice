package com.ecommercepractice.authentication.controller;


import com.ecommercepractice.authentication.dao.AuthDao;
import com.ecommercepractice.authentication.model.AuthMobile;

import com.ecommercepractice.authentication.model.AuthenticationModel;
import com.ecommercepractice.authentication.model.MobileInfoModel;
import com.ecommercepractice.authentication.model.TokenModel;
import com.ecommercepractice.authentication.repository.AuthenticationRepository;
import com.ecommercepractice.authentication.service.AuthService;
import com.ecommercepractice.authentication.service.MobileService;
import com.ecommercepractice.authentication.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@Api(value = "Authentication user portal",
    consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@ApiResponses(
        value = {
                @ApiResponse(code = 200, message = "Auth OK")
        }
)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    AuthService authService;

    @Autowired
    MobileService mobileService;

    @Autowired
    TokenService tokenService;


    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public String register(
            @Valid @RequestBody AuthenticationModel authentication

            ) {

        log.info(String.format("AUTH | REGISTER | Payload AUTH { %s }",authentication));
        AuthenticationModel authCreated =  authService.register(authentication);

        return "Created as " + authCreated ;
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public String logIn(
            @Valid  @RequestBody AuthMobile authMobile
            ) {

        if (! (authMobile.getMobileInfo() == null)){
            log.info(String.format("AUTH | LOGIN | Payload AUTH / MOBILE { %s }",authMobile));
            mobileService.register(authMobile.getMobileInfo());

        }else{
            log.info(String.format("AUTH | LOGIN | Payload AUTH { %s }",authMobile.getUserInfo()));
        }

        AuthenticationModel userLogged = authService.login(authMobile.getUserInfo());
        return "User founded as " + userLogged ;
    }


    @GetMapping("/validate/{userEmail:.+}/{tokenId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void validateToken(
            @PathVariable String userEmail,
            @PathVariable String tokenId
            ){

        log.info(String.format("AUTH | VALIDATE | PAYLOAD { userEmail -> %s | tokenId -> %s }",userEmail,tokenId));
        authService.validateAuth(userEmail,tokenId);
    }

    @DeleteMapping("/logout")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void logOut(){

    }

}
