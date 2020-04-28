package com.ecommercepractice.authentication.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "Authentication and mobileInfo",
        description = "Holds Authentication and mobileInfo data objects" +
                ", it is used on login to provide more information" +
                " related to the user.")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthMobile {

    @NotNull
    @Valid
    @ApiModelProperty(value = "Authentication model", required = true)
    private AuthenticationModel userInfo;

    @Valid
    @ApiModelProperty(value = "Mobile Info model", required = false)
    private MobileInfoModel mobileInfo;
}
