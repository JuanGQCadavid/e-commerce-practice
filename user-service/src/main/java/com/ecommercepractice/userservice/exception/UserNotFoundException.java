package com.ecommercepractice.userservice.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class UserNotFoundException extends RuntimeException {
    public Long payload;

    public UserNotFoundException(Long userId){
        super(String.format("User %s not found ",userId));
        this.payload = userId;
        log.error(this.getMessage());
    }

}
