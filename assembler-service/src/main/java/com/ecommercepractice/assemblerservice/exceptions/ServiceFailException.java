package com.ecommercepractice.assemblerservice.exceptions;

import com.ecommercepractice.assemblerservice.models.ServiceFail;
import com.ecommercepractice.utilities.exception.GeneralException;

public class ServiceFailException extends GeneralException {

    public ServiceFailException(ServiceFail payload) {
        super(String.format("The service return with an error."), ErrorType.SERVICE_FAIL_RESPONSE.generateGeneral(), payload);
    }
}
