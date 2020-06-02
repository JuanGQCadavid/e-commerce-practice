package com.ecommercepractice.assemblerservice.models.assemblerModels;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfo {

    @ApiModelProperty(value = "Unique user identifier")
    private  Long userId;

    @ApiModelProperty(value = "User's firstName")
    private  String firstName;

    @ApiModelProperty(value = "User's secondName")
    private  String lastName;

    @NotNull
    @ApiModelProperty(value = "Flag that indicates the user state, True indicates tha the user is Activate, no activate in the other case ")
    private  boolean isActive;

    @ApiModelProperty(value = "User's email")
    private  String email;
}
