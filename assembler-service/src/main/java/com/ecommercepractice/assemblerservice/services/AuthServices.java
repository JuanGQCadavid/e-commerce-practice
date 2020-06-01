package com.ecommercepractice.assemblerservice.services;

import com.ecommercepractice.assemblerservice.models.authModels.AuthRegisterRequest;
import com.ecommercepractice.assemblerservice.models.authModels.AuthRegisterResponse;
import io.reactivex.Observable;
import org.springframework.hateoas.EntityModel;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthServices {
    @POST("auth/register")
    Observable<EntityModel<AuthRegisterResponse>> registerAuth (@Body AuthRegisterRequest authRegisterRequest);
}
