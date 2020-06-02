package com.ecommercepractice.assemblerservice.controller.imp;

import com.ecommercepractice.assemblerservice.controller.RestUserAssembler;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserDetails;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserInfo;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthLoginModelRequest;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthTokenResponse;
import com.ecommercepractice.assemblerservice.services.UserAssemblerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Map;


@Slf4j
@Controller
public class RestUserAssemblerImp implements RestUserAssembler {
    @Autowired
    UserAssemblerService userAssemblerService;

    @Value("${spring.application.name}")
    private String appName;

    public ResponseEntity userRegister(@Valid @RequestBody UserRegister userRegister){
        log.info(String.format(" %s | USER | REGISTER", appName));
        return new ResponseEntity(userAssemblerService.userRegister(userRegister), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDetails> userLogIn(@Valid AuthLoginModelRequest authMobile) {
        log.info(String.format(" %s | USER | LOG IN", appName));
        return new ResponseEntity(userAssemblerService.userLogIn(authMobile),HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity userLogOut(Map<String, String> headers) {
        log.info(String.format(" %s | USER | LOG OUT", appName));
        userAssemblerService.userLogOut(headers);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
