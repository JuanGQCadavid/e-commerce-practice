package com.ecommercepractice.authentication.controller;


import com.ecommercepractice.authentication.model.AuthMobile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
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



    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public String register(
            @Valid  @RequestBody AuthMobile authMobile
            ) {

        return "Created with mobileInfo and Auth ->" + authMobile ;
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public void logIn() {

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
