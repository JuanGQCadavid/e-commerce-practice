package com.ecommercepractice.assemblerservice.controller;

import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthLoginModelRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("api/v1/assembler/users")
public interface RestUserAssembler {
    @PostMapping("/register")
    ResponseEntity userRegister(@Valid @RequestBody UserRegister userRegister);

    @PostMapping("/login")
    ResponseEntity userLogIn(@Valid @RequestBody AuthLoginModelRequest authMobile);

    @DeleteMapping("/logout")
    ResponseEntity userLogOut(@RequestHeader Map<String, String> headers);
}
