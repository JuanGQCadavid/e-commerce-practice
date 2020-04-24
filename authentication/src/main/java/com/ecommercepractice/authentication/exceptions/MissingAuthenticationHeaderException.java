package com.ecommercepractice.authentication.exceptions;
import com.ecommercepractice.authentication.util.Pair;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
public class MissingAuthenticationHeaderException extends RuntimeException {
    private Pair<String,String> payload;
    public MissingAuthenticationHeaderException(){
        super("Missing Token Header");
        payload = new Pair<>("header","authorization");
    }
}
