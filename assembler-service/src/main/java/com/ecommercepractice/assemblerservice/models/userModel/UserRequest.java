package com.ecommercepractice.assemblerservice.models.userModel;


import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserRequest {
    @NotNull
    @Size(max = 24)
    @ApiModelProperty(value = "User's firstName")
    private  String firstName;

    @NotNull
    @Size(max = 24)
    @ApiModelProperty(value = "User's secondName")
    private  String lastName;

    @ApiModelProperty(value = "Flag that indicates the user state, True indicates tha the user is Activate, no activate in the other case ")
    private  boolean isActive;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private  String email;
}
