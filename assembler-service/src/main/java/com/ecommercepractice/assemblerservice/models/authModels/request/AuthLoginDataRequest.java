package com.ecommercepractice.assemblerservice.models.authModels.request;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "Authentication",
        description = "Holds the information related to user Authentication"
)
public class AuthLoginDataRequest {
    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private String userEmail;

    @NotNull
    @Size(min= 6, max = 24)
    @ApiModelProperty(value = "User's password")
    private String userPassword;
}
