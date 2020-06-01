package com.ecommercepractice.assemblerservice.controller;

import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import com.ecommercepractice.assemblerservice.services.AssemblerServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("api/v1/assembler")
public class AssemblerController {
    @Autowired
    AssemblerServices assemblerServices;

    @Value("${spring.application.name}")
    private String appName;

    @PostMapping("/user/register")
    public ResponseEntity userRegister(@Valid @RequestBody UserRegister userRegister){
        log.info(String.format(" %s | USER | REGISTER", appName));
        return new ResponseEntity(assemblerServices.userRegister(userRegister), HttpStatus.OK);
    }
}
