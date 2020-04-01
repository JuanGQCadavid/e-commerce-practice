package com.ecommercepractice.userservice.exception;

public class UserAlreadyCreatedException extends RuntimeException{
    public UserAlreadyCreatedException(String userId){
        super(String.format("Failed to create user with userId %s. User with %s already exist", userId));
    }
}
