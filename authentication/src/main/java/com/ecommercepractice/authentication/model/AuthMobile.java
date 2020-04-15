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
    private AuthenticationModel userInfo;

    @Valid
    private MobileInfoModel mobileInfo;
}
