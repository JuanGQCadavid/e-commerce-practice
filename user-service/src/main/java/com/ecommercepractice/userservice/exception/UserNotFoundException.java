package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.utilities.exception.GeneralException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
/**
 * User exception.
 *
 * The user that we are trying to perform an action does not exist.
 */
@Getter
@Slf4j
public class UserNotFoundException extends GeneralException {
    public UserNotFoundException(Long userId){
        super(String.format("User %s not found ",userId),ErrorType.USER_NOT_FOUND.generateGeneral(), userId);
    }

}
