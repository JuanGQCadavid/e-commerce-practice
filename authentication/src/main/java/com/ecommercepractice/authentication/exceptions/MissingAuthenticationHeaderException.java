package com.ecommercepractice.authentication.exceptions;
import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
public class MissingAuthenticationHeaderException extends AuthException {
    public MissingAuthenticationHeaderException(){
        super("Missing Token Header",  new Pair<>("header","authorization"), ErrorType.MISSING_AUTH_HEADER);
    }
}
