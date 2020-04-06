package com.ecommercepractice.userservice.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class UserNotFoundException extends RuntimeException {
    public String payload;

    public UserNotFoundException(String userID){
        super(String.format("User %s not found ",userID));
        this.payload = userID;
        log.error(this.getMessage());
    }

}
