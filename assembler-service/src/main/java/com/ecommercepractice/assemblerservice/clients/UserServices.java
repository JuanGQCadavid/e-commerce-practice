package com.ecommercepractice.assemblerservice.clients;

import com.ecommercepractice.assemblerservice.models.assemblerModels.UserInfo;
import com.ecommercepractice.assemblerservice.models.userModel.UserRequest;
import com.ecommercepractice.assemblerservice.models.userModel.UserResponse;
import io.reactivex.Observable;
import org.springframework.hateoas.EntityModel;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserServices {
    @POST("users/")
    Observable<EntityModel<UserResponse>> createUser(@Body UserRequest userRequest);

    @GET("users/email/{userEmail}")
    Observable<EntityModel<UserInfo>> fetchUserByEmail(@Path("userEmail") String userEmail);

}
