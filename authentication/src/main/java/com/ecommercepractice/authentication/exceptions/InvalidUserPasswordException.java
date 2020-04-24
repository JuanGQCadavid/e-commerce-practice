package com.ecommercepractice.authentication.exceptions;
import com.ecommercepractice.authentication.util.Pair;

/**
 * The User email exist, but the password associated to the email
 * is wrong.
 */
public class InvalidUserPasswordException extends AuthException {
    public InvalidUserPasswordException(String email, String password){
        super(String.format("Invalid user password { %s } for email { %s }",password,email),new Pair<>(email,password),ErrorType.INVALID_PASSWORD);
    }

}
