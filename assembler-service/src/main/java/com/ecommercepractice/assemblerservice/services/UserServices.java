package com.ecommercepractice.assemblerservice.services;

import com.ecommercepractice.assemblerservice.models.userModel.UserRequest;
import com.ecommercepractice.assemblerservice.models.userModel.UserResponse;
import io.reactivex.Observable;
import org.springframework.hateoas.EntityModel;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserServices {
    @POST("users/")
    Observable<EntityModel<UserResponse>> createUser(@Body UserRequest userRequest);

}
