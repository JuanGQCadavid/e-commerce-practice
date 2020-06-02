package com.ecommercepractice.assemblerservice.models.authModels.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthLoginModelRequest {
    @NotNull
    @Valid
    @ApiModelProperty(value = "Authentication model", required = true)
    @JsonProperty("userInfo")
    private AuthLoginDataRequest userInfo;

    @Valid
    @ApiModelProperty(value = "Mobile Info model", required = false)
    @JsonProperty("mobileInfo")
    private AuthLoginMobileInfoRequest mobileInfo;
}
