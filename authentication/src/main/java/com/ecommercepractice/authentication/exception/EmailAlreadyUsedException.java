package com.ecommercepractice.authentication.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class EmailAlreadyUsedException extends RuntimeException {
    private String payload;

    public EmailAlreadyUsedException(String email){
        super(String.format("The email { %s } is already associated with an account.",email));
        this.payload = email;
        log.error(this.getMessage());
    }

}
