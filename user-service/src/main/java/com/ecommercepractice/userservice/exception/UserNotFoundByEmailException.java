package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;

public class UserNotFoundByEmailException extends GeneralException {
    public UserNotFoundByEmailException(String userEmail){
        super(String.format("User with email %s not found ",userEmail),ErrorType.USER_NOT_FOUND.generateGeneral(), userEmail);
    }

}
