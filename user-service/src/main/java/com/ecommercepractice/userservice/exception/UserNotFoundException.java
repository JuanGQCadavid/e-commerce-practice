package com.ecommercepractice.userservice.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    public String badUser;

    public UserNotFoundException(String userID){
        super(String.format("User %s not found ",userID));
        this.badUser = userID;
    }

}
