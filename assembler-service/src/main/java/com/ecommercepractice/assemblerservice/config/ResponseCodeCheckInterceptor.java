package com.ecommercepractice.assemblerservice.config;

import com.ecommercepractice.assemblerservice.exceptions.ServiceFailException;
import com.ecommercepractice.assemblerservice.exceptions.ServiceUnavailableException;
import com.ecommercepractice.assemblerservice.models.ServiceFail;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.ConnectException;

@Slf4j
public class ResponseCodeCheckInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        try{
            Request request = chain.request();
            log.info(String.format("Making a petition to %s",request.url().toString()));
            Response response = chain.proceed(request);

            if (response.isSuccessful()){
                return response;
            }

            throw new ServiceFailException(castError(response));

        } catch(ConnectException connectException){
            throw new ServiceUnavailableException();
        }
    }

    public ServiceFail castError(Response responseCall) throws IOException {
        String err = responseCall.body().string();

        System.out.println(err);

        if (err.isEmpty()){
            return ServiceFail.builder()
                    .errorType("NONE")
                    .message("NONE")
                    .payload("NONE")
                    .timeStamp("NONE")
                    .build();
        }

        System.out.println();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(err, ServiceFail.class);
    }
}
