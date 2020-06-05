package com.ecommercepractice.assemblerservice.services;

import com.ecommercepractice.assemblerservice.clients.AuthServices;
import com.ecommercepractice.assemblerservice.clients.UserServices;
import com.ecommercepractice.assemblerservice.exceptions.MissingAuthenticationHeaderException;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserDetails;
import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthLoginModelRequest;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthRegisterRequest;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthRegisterResponse;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthTokenResponse;
import com.ecommercepractice.assemblerservice.models.userModel.UserRequest;
import com.ecommercepractice.assemblerservice.models.userModel.UserResponse;
import com.ecommercepractice.assemblerservice.services.mappers.UserAssemblerMappers;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserAssemblerService {
    @Autowired
    private AuthServices authServices;

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserAssemblerMappers mappers;

    public HashMap<String,Object> userRegister(UserRegister userRegister) {
        AuthRegisterRequest authRegisterRequest = mappers.buildAuthRegisterRequest(userRegister);
        UserRequest userRequest = mappers.buildUserRegisterRequest(userRegister);

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

    public UserDetails userLogIn(AuthLoginModelRequest authMobile) {
         return authServices.logInAuth(authMobile)
                 .flatMap(authTokenResponseEntityModel -> userDetailsObservable(authTokenResponseEntityModel, authMobile))
                .blockingFirst();

    }

    private Observable<UserDetails> userDetailsObservable (EntityModel<AuthTokenResponse> authTokenResponseEntityModel,
                                                           AuthLoginModelRequest authMobile){
        return  userServices.fetchUserByEmail(authMobile.getUserInfo().getUserEmail())
                    .map(userInfoEntityModel ->
                            mappers.castUserProfile(authTokenResponseEntityModel.getContent(),
                            userInfoEntityModel.getContent()));
    }

    public void userLogOut(Map<String, String> headers) {
        String tokenHeader = checkAuthHeader(headers);
        authServices.logOutAuth(tokenHeader).blockingFirst();
    }

    private String checkAuthHeader(Map<String, String> headers) {
        return  Optional.ofNullable(headers.get("authorization"))
                .orElseThrow(() -> new MissingAuthenticationHeaderException());
    }
}