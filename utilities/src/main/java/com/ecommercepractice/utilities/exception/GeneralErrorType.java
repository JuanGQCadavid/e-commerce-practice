package com.ecommercepractice.utilities.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class GeneralErrorType {
    private String label;
    private HttpStatus status;
}
