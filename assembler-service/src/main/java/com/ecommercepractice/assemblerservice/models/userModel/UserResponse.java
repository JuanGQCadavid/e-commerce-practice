package com.ecommercepractice.assemblerservice.models.userModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @ApiModelProperty(value = "Unique user identifier")
    private  Long userId;


    @ApiModelProperty(value = "User's firstName")
    private  String firstName;


    @ApiModelProperty(value = "User's secondName")
    private  String lastName;

    @ApiModelProperty(value = "Flag that indicates the user state, True indicates tha the user is Activate, no activate in the other case ")
    private  boolean isActive;


    @ApiModelProperty(value = "User's email")
    private  String email;
}
