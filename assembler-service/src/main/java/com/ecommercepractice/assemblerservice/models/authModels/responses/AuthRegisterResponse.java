package com.ecommercepractice.assemblerservice.models.authModels.responses;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegisterResponse {

    private int idAuthentication;

    @ApiModelProperty(value = "Unique user token, used by the client to identified itself after log in.")
    private String idToken;

    @ApiModelProperty(value = "User's email")
    private String userEmail;

    @ApiModelProperty(value = "User's password")
    private String userPassword;
}
