package com.ecommercepractice.utilities.exception;

import com.ecommercepractice.utilities.config.ConstantsWords;
import org.springframework.http.HttpStatus;

public class MissingValuesException extends GeneralException {
    public MissingValuesException(Object Payload) {
        super("There is a problem with the fields format.",
                new GeneralErrorType(ConstantsWords.MISSING_FIELDS, HttpStatus.BAD_REQUEST), Payload);
    }
}
