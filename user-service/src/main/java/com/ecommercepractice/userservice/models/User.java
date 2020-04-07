package com.ecommercepractice.userservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="User",description="Module used to represent the user data onto the system")
public class User {
    @NotNull
    @Size(min = 6, max=24)
    @ApiModelProperty(value = "Unique user identifier")
    private  String userId;

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

    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private  String email;

}
