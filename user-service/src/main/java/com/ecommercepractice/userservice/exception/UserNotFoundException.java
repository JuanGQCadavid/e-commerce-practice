package com.ecommercepractice.userservice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userID){
        super(String.format("User %s not found ",userID));
    }
}
