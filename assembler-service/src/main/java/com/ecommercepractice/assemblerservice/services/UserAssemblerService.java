package com.ecommercepractice.assemblerservice.services;

import com.ecommercepractice.assemblerservice.models.assemblerModels.UserDetails;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserInfo;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthLoginModelRequest;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthRegisterRequest;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthRegisterResponse;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthTokenResponse;
import com.ecommercepractice.assemblerservice.models.userModel.UserRequest;
import com.ecommercepractice.assemblerservice.models.userModel.UserResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserAssemblerService {
    @Autowired
    private AuthServices authServices;

    @Autowired
    private UserServices userServices;

    public HashMap<String,Object> userRegister(UserRegister userRegister) {
        AuthRegisterRequest authRegisterRequest = buildAuthRegisterRequest(userRegister);
        UserRequest userRequest = buildUserRegisterRequest(userRegister);

        return Observable.zip(authServices.registerAuth(authRegisterRequest), userServices.createUser(userRequest),
                (authRegisterResponseEntityModel, userResponseEntityModel) ->
                        zipUserRegisterResponse(authRegisterResponseEntityModel,userResponseEntityModel))
                .blockingFirst();
    }

    private HashMap<String,Object> zipUserRegisterResponse(EntityModel<AuthRegisterResponse> authRegisterRequestEntityModel,
                                                        EntityModel<UserResponse> userRequestEntityModel){
        HashMap<String,Object> zipResponse = new HashMap<>();
        zipResponse.put("AUTH",authRegisterRequestEntityModel.getLinks());
        zipResponse.put("USER",userRequestEntityModel.getLinks());

        return zipResponse;
    }

    private AuthRegisterRequest buildAuthRegisterRequest(UserRegister userRegister){
        return AuthRegisterRequest.builder()
                .userEmail(userRegister.getUserEmail())
                .userPassword(userRegister.getUserPassword())
                .build();
    }

    private UserRequest buildUserRegisterRequest(UserRegister userRegister){
        return UserRequest.builder()
                .email(userRegister.getUserEmail())
                .firstName(userRegister.getFirstName())
                .lastName(userRegister.getLastName())
                .isActive(true)
                .build();
    }

    public UserDetails userLogIn(AuthLoginModelRequest authMobile) {
         return authServices.logInAuth(authMobile)
                 .flatMap(authTokenResponseEntityModel -> userDetailsObservable(authTokenResponseEntityModel, authMobile))
                .blockingFirst();

    }

    private Observable<UserDetails> userDetailsObservable (EntityModel<AuthTokenResponse> authTokenResponseEntityModel,
                                                           AuthLoginModelRequest authMobile){
        return  userServices.fetchUserByEmail(authMobile.getUserInfo().getUserEmail())
                    .map(userInfoEntityModel ->
                            castUserProfile(authTokenResponseEntityModel.getContent(),
                            userInfoEntityModel.getContent()));
    }

    private UserDetails castUserProfile(AuthTokenResponse authTokenResponse, UserInfo userInfo) {
        return UserDetails.builder()
                .userGeneralInfo(userInfo)
                .userToken(authTokenResponse)
                .build();
    }

    public void userLogOut(Map<String, String> headers) {

    }
}