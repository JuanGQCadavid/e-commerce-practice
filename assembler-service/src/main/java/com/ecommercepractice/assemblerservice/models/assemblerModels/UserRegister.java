package com.ecommercepractice.assemblerservice.models.assemblerModels;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {
    // User service

    @NotNull
    @Size(max = 24)
    @ApiModelProperty(value = "User's firstName")
    private  String firstName;

    @NotNull
    @Size(max = 24)
    @ApiModelProperty(value = "User's secondName")
    private  String lastName;

    // Auth Service.

    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private String userEmail;

    @NotEmpty
    @Size(min= 6, max = 24)
    @ApiModelProperty(value = "User's password")
    private String userPassword;
}
