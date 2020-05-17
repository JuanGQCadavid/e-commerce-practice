package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.userservice.models.User;
import com.ecommercepractice.utilities.exception.GeneralException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * User exception.
 *
 * Indicates the user that are attempting to save is already on the
 * register.
 *
 * We base on the user email to know if the user is already or not saved.
 */
@Getter
@Slf4j
public class UserAlreadyCreatedException extends GeneralException {
    public UserAlreadyCreatedException(String email, User badUser){
        super(String.format("User with email %s already exist", email),
                ErrorType.USER_ALREADY_CREATED.generateGeneral(),badUser);
    }
}
