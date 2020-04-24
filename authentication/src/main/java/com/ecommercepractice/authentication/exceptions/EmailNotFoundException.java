package com.ecommercepractice.authentication.exceptions;
import lombok.Getter;
/**
 * The email does not exist on the system register.
 */
@Getter
public class EmailNotFoundException extends  RuntimeException{
    private String payload;
    public EmailNotFoundException(String email){
        super(String.format("Email { %s } not founded",email));
        this.payload = email;
    }
}
