package com.ecommercepractice.assemblerservice.models.authModels.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Authentication", description = "All info related user's device would be represented by Authentication model.")
public class AuthLoginMobileInfoRequest {
    @NotEmpty
    @ApiModelProperty("Mobile brand aka Motorola, Samsung and so on.")
    private String mobileBrand;

    @NotEmpty
    @ApiModelProperty("iOs, Android ...")
    private String operatingSystem;

    @NotEmpty
    @ApiModelProperty("Operating System version.")
    private String systemVersion;
}
