package com.ecommercepractice.authentication.exceptions;
import lombok.Getter;

@Getter
public class EmailAlreadyUsedException extends RuntimeException {
    private String payload;
    public EmailAlreadyUsedException(String email){
        super(String.format("The email { %s } is already associated with an account.",email));
        this.payload = email;
    }
}
