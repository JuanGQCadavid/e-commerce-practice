package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

/**
 * The User email exist, but the password associated to the email
 * is wrong.
 */
public class InvalidUserPasswordException extends GeneralException {
    public InvalidUserPasswordException(String email, String password){
        super(String.format("Invalid user password { %s } for email { %s }",password,email),
                ErrorType.INVALID_PASSWORD.generateGeneral(), new Pair<>(email,password));
    }

}
