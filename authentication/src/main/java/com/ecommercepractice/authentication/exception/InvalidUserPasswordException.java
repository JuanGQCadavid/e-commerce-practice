package com.ecommercepractice.authentication.exception;

import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class InvalidUserPasswordException extends RuntimeException {
    private Pair<String, String> payload;

    public InvalidUserPasswordException(String email, String password){
        super(String.format("Invalid user password { %s } for email { %s }",password,email));
        this.payload = new Pair<>(email,password);
        log.error(this.getMessage());
    }

}
