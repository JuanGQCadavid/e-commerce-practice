package com.ecommercepractice.assemblerservice.services.mappers;

import com.ecommercepractice.assemblerservice.models.assemblerModels.UserDetails;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserInfo;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthRegisterRequest;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthTokenResponse;
import com.ecommercepractice.assemblerservice.models.userModel.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserAssemblerMappers {

    public UserDetails castUserProfile(AuthTokenResponse authTokenResponse, UserInfo userInfo) {
        return UserDetails.builder()
                .userGeneralInfo(userInfo)
                .userToken(authTokenResponse)
                .build();
    }

    public AuthRegisterRequest buildAuthRegisterRequest(UserRegister userRegister){
        return AuthRegisterRequest.builder()
                .userEmail(userRegister.getUserEmail())
                .userPassword(userRegister.getUserPassword())
                .build();
    }

    public UserRequest buildUserRegisterRequest(UserRegister userRegister){
        return UserRequest.builder()
                .email(userRegister.getUserEmail())
                .firstName(userRegister.getFirstName())
                .lastName(userRegister.getLastName())
                .isActive(true)
                .build();
    }

}
