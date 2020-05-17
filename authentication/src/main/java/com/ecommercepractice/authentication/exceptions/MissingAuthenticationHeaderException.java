package com.ecommercepractice.authentication.exceptions;

import com.ecommercepractice.utilities.exception.GeneralException;
import com.ecommercepractice.utilities.util.Pair;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
public class MissingAuthenticationHeaderException extends GeneralException {
    public MissingAuthenticationHeaderException(){
        super("Missing Token Header",  ErrorType.MISSING_AUTH_HEADER.generateGeneral(),
                new Pair<>("header","authorization"));
    }
}
