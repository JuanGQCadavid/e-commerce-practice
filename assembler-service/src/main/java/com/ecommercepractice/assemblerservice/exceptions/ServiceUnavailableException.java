package com.ecommercepractice.assemblerservice.exceptions;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

public class ServiceUnavailableException extends GeneralException {
    public ServiceUnavailableException() {
        super("The service is currently unavailable", ErrorType.SERVICE_UNAVAILABLE.generateGeneral(),
                new Pair<>("Service error","Service not available"));
    }
}
