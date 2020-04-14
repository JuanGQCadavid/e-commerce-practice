package com.ecommercepractice.authentication.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthMobile {

    @NotNull
    @Valid
    protected AuthenticationModel userInfo;

    protected MobileInfoModel mobileInfo;
}
