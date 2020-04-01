package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.userservice.models.User;
import lombok.Getter;

@Getter
public class UserAlreadyCreatedException extends RuntimeException{
    public User badUser;

    public UserAlreadyCreatedException(String userId, User badUser){
        super(String.format("Failed to create user with userId %s. User with %s already exist", userId));
        this.badUser = badUser;
    }


}
