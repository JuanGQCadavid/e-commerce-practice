package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralException;

/**
 * The email does not exist on the system register.
 */
public class EmailNotFoundException extends GeneralException {
    public EmailNotFoundException(String email){
        super(String.format("Email { %s } not founded",email),
                ErrorType.EMAIL_NOT_FOUND.generateGeneral(), email);
    }
}
