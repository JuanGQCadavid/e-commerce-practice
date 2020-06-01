package com.ecommercepractice.assemblerservice.services;

import com.ecommercepractice.assemblerservice.models.assemblerModels.UserRegister;
import com.ecommercepractice.assemblerservice.models.authModels.AuthRegisterRequest;
import com.ecommercepractice.assemblerservice.models.authModels.AuthRegisterResponse;
import com.ecommercepractice.assemblerservice.models.userModel.UserRequest;
import com.ecommercepractice.assemblerservice.models.userModel.UserResponse;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AssemblerServices {
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
}