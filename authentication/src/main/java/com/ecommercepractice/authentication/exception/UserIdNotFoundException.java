package com.ecommercepractice.authentication.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class UserIdNotFoundException extends RuntimeException {
    private String payload;

    public UserIdNotFoundException(String userId){
        super(String.format("UserId { %s } not founded",userId));
        this.payload = userId;
        log.error(this.getMessage());
    }
}
