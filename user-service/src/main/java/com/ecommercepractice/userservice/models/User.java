package com.ecommercepractice.userservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private  String userId;
    private  String firstName;
    private  String secondName;
    private  boolean isActive;
    private  String email;

}
