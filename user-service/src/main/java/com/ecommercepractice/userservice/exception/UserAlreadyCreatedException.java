package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.userservice.models.User;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class UserAlreadyCreatedException extends RuntimeException{
    public User payload;

    public UserAlreadyCreatedException(String email, User badUser){
        super(String.format("User with email %s already exist", email));
        this.payload = badUser;
        log.error(this.getMessage());
    }


}
