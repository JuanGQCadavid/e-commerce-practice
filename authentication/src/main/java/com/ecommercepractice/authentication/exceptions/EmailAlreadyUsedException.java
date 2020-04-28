package com.ecommercepractice.authentication.exceptions;
public class EmailAlreadyUsedException extends AuthException {
    public EmailAlreadyUsedException(String email){
        super(String.format("The email { %s } is already associated with an account.",email), email, ErrorType.EMAIL_ALREADY_USED);
    }
}
