package com.ecommercepractice.assemblerservice.exceptions;

import com.ecommercepractice.utilities.exception.GeneralErrorType;
import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;

public class MissingAuthenticationHeaderException extends GeneralException {
    public MissingAuthenticationHeaderException() {
        super("authorization Header missing inside the headers", ErrorType.AUTH_HEADER_MISSING.generateGeneral()
                ,new Pair<>("header","authorization"));
    }
}
