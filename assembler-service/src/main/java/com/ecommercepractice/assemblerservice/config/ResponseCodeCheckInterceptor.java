package com.ecommercepractice.assemblerservice.config;

import com.ecommercepractice.assemblerservice.exceptions.ServiceFailException;
import com.ecommercepractice.assemblerservice.models.ServiceFail;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class ResponseCodeCheckInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain .proceed(chain.request());
        if (response.isSuccessful()){
            return response;
        }
        throw new ServiceFailException(castError(response));
    }

    public ServiceFail castError(Response responseCall) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseCall.body().string(), ServiceFail.class);
    }
}
