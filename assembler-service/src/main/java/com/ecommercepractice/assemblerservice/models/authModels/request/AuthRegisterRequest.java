package com.ecommercepractice.assemblerservice.models.authModels.request;

import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Data
public class AuthRegisterRequest {
    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private String userEmail;

    @NotEmpty
    @Size(min= 6, max = 24)
    @ApiModelProperty(value = "User's password")
    private String userPassword;

}
