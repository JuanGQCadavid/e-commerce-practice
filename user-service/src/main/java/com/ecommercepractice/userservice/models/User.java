package com.ecommercepractice.userservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@ApiModel(value="User",description="Module used to represent the user data onto the system")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Unique user identifier")
    private  Long userId;

    @NotNull
    @Size(min= 6, max = 24)
    @ApiModelProperty(value = "User's password")
    private String password;

    @NotNull
    @Size(max = 24)
    @ApiModelProperty(value = "User's firstName")
    private  String firstName;

    @NotNull
    @Size(max = 24)
    @ApiModelProperty(value = "User's secondName")
    private  String secondName;

    @NotNull
    @ApiModelProperty(value = "Flag that indicates the user state, True indicates tha the user is Activate, no activate in the other case ")
    private  boolean isActive;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private  String email;

    public User(String password, String firstName, String secondName, boolean isActive, String email){
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isActive = isActive;
        this.email = email;
    }

}
