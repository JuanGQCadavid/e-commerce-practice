package com.ecommercepractice.authentication.exceptions;
import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;

/**
 * The User email exist, but the password associated to the email
 * is wrong.
 */
@Getter
public class InvalidUserPasswordException extends RuntimeException {
    private Pair<String, String> payload;
    public InvalidUserPasswordException(String email, String password){
        super(String.format("Invalid user password { %s } for email { %s }",password,email));
        this.payload = new Pair<>(email,password);
    }

}
