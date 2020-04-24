package com.ecommercepractice.authentication.exceptions;
/**
 * The email does not exist on the system register.
 */
public class EmailNotFoundException extends AuthException{
    public EmailNotFoundException(String email){
        super(String.format("Email { %s } not founded",email),email,ErrorType.EMAIL_NOT_FOUND);
    }
}
