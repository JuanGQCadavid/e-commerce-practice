package com.ecommercepractice.assemblerservice.services;

import com.ecommercepractice.assemblerservice.models.authModels.request.AuthLoginModelRequest;
import com.ecommercepractice.assemblerservice.models.authModels.request.AuthRegisterRequest;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthRegisterResponse;
import com.ecommercepractice.assemblerservice.models.authModels.responses.AuthTokenResponse;
import io.reactivex.Observable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthServices {

    final String ENDPOINT_PREFIX = "auth";

    @POST(ENDPOINT_PREFIX + "/register")
    Observable<EntityModel<AuthRegisterResponse>> registerAuth (@Body AuthRegisterRequest authRegisterRequest);

    @POST(ENDPOINT_PREFIX + "/login")
    Observable<EntityModel<AuthTokenResponse>> logInAuth(@Body AuthLoginModelRequest authLoginModelRequest);

    @POST(ENDPOINT_PREFIX + "/logout")
    Observable<ResponseEntity> logOutAuth();
}
