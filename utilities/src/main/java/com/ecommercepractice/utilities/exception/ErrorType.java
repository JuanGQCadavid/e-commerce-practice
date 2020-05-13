package com.ecommercepractice.utilities.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {
    MISSING_FIELDS       ("MissingFieldsBody",HttpStatus.BAD_REQUEST)
    ;
    private String label;
    private HttpStatus status;
}
