package com.ecommercepractice.authentication.controller;

import com.ecommercepractice.authentication.exception.MissingAuthenticationHeaderException;
import com.ecommercepractice.authentication.model.AuthMobile;
import com.ecommercepractice.authentication.model.AuthenticationModel;
import com.ecommercepractice.authentication.model.TokenModel;
import com.ecommercepractice.authentication.service.AuthService;
import com.ecommercepractice.authentication.service.MobileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Api(value = "Authentication user portal",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@ApiResponses(
        value = {
                @ApiResponse(code = 200, message = "OK -> The information sent is correctly."),
                @ApiResponse(code = 201, message = "CREATED -> The information sent is currently onto the database"),
                @ApiResponse(code = 204, message = "NO_CONTENT -> The server do the action correctly and does not return a value")
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
    AuthenticationModelAssembler authenticationModelAssembler;

    @ApiOperation(value = "CREATE Auth",
            response = AuthenticationModel.class,
            responseContainer = "ResponseEntity<EntityModel>")
    @PostMapping("/register")
    public ResponseEntity<EntityModel<AuthenticationModel>> register(@Valid @RequestBody AuthenticationModel authentication) {
        log.info(String.format("AUTH | REGISTER | Payload AUTH { %s }", authentication));
        return new ResponseEntity<EntityModel<AuthenticationModel>>(
                authenticationModelAssembler.toModelRegister(authService.register(authentication)),
                HttpStatus.CREATED
        );
    }

    @ApiOperation(value = "LOGIN ",
            response = AuthenticationModel.class,
            notes = "-> User credential validator and token generator.")
    @PostMapping("/login")
    public ResponseEntity<EntityModel<TokenModel>> logIn(@Valid @RequestBody AuthMobile authMobile) {

        if (authMobile.getMobileInfo() != null) {
            log.info(String.format("AUTH | LOGIN | Payload AUTH / MOBILE { %s }", authMobile));
            mobileService.register(authMobile.getMobileInfo());

        } else {
            log.info(String.format("AUTH | LOGIN | Payload AUTH { %s }", authMobile.getUserInfo()));
        }

        return new ResponseEntity<EntityModel<TokenModel>>(
                authenticationModelAssembler.toModelLogIn(authMobile.getUserInfo(),
                        authService.login(authMobile.getUserInfo())),
                HttpStatus.OK
        );
    }

    @ApiOperation(value = "VALIDATE -> tokenID for userEmail",
            response = java.lang.Void.class,
            notes = "Validate if the token exists and if it exists validate if it is" +
                    "currently, attached to the userEmail")
    @GetMapping("/validate/{userEmail:.+}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity validateToken(@RequestHeader Map<String, String> headers,@PathVariable String userEmail) {

        String tokenId = Optional.ofNullable(headers.get("authorization"))
                .orElseThrow(() -> new MissingAuthenticationHeaderException());
        log.info(String.format("AUTH | VALIDATE | PAYLOAD { userEmail -> %s | tokenId -> %s }", userEmail, tokenId));
        authService.validateAuth(userEmail, tokenId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @ApiOperation(value = "LOGOUT -> TokenId",
            response = java.lang.Void.class,
            notes = "Delete the current token from the userEmail associated"
    )
    @DeleteMapping("/logout")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity logOut(@RequestHeader Map<String, String> headers) {
        String tokenId = Optional.ofNullable(headers.get("authorization"))
                .orElseThrow(() -> new MissingAuthenticationHeaderException());
        log.info(String.format("AUTH | LOGOUT | PAYLOAD { tokenId -> %s }", tokenId));
        authService.logout(tokenId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
