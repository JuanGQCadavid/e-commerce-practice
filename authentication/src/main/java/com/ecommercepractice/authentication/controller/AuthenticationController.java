package com.ecommercepractice.authentication.controller;


import com.ecommercepractice.authentication.dao.AuthDao;
import com.ecommercepractice.authentication.model.AuthMobile;

import com.ecommercepractice.authentication.model.AuthenticationModel;
import com.ecommercepractice.authentication.model.MobileInfoModel;
import com.ecommercepractice.authentication.repository.AuthenticationRepository;
import com.ecommercepractice.authentication.service.AuthService;
import com.ecommercepractice.authentication.service.MobileService;
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

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public String register(
            @Valid  @RequestBody AuthMobile authMobile
            ) {

        if (! (authMobile.getMobileInfo() == null)){
            log.error("Not implemented");
            //mobileService.register(authMobile.getMobileInfo());
        }
        AuthenticationModel authCreated =  authService.register(authMobile.getUserInfo());
        return "Created as " + authCreated ;
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public String logIn(
            @Valid @RequestBody AuthenticationModel authenticationModel
            ) {

        log.info(String.format("AUTH | LOGIN | Payload { %s }",authenticationModel));
        AuthenticationModel userLogged = authService.login(authenticationModel);

        return "User founded as " + userLogged ;
    }


    @GetMapping("/validate/{tokenId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void validateToken(){

    }

    @DeleteMapping("/logout")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void logOut(){

    }

}
