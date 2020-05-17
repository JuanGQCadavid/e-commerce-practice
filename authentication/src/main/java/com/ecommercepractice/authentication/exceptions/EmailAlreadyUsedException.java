package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralException;

public class EmailAlreadyUsedException extends GeneralException {
    public EmailAlreadyUsedException(String email){
        super(String.format("The email { %s } is already associated with an account.",email),
                ErrorType.EMAIL_ALREADY_USED.generateGeneral(), email);
    }
}
