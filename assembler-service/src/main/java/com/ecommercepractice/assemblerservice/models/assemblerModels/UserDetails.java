package com.ecommercepractice.assemblerservice.models.assemblerModels;

import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthTokenResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private UserInfo userGeneralInfo;

    private AuthTokenResponse userToken;
}
