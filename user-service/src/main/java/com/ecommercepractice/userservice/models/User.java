package com.ecommercepractice.userservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @NotNull
    @Size(min = 6, max=24)
    private  String userId;

    @NotNull
    @Size(max = 24)
    private  String firstName;

    @NotNull
    @Size(max = 24)
    private  String secondName;

    @NotNull
    private  boolean isActive;

    @NotNull
    private  String email;

}
