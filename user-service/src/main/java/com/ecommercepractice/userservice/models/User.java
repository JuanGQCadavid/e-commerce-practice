package com.ecommercepractice.userservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User model.
 *
 * It holds the user information like:
 *
 *  - userId -> auto generated.
 *  - password -> @Size(min= 6, max = 24) @NotNull
 *  - firstName -> @Size(max = 24) @NotNull
 *  - secondName -> @Size(max = 24) @NotNull
 *  - isActive -> true / false @NotNull
 *  - email -> @NotNull
 */
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
    private  String lastName;

    @NotNull
    @ApiModelProperty(value = "Flag that indicates the user state, True indicates tha the user is Activate, no activate in the other case ")
    private  boolean isActive;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private  String email;

    public User(String password, String firstName, String lastName, boolean isActive, String email){
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.email = email;
    }

}
