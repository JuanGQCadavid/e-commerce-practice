package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.userservice.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyCreatedException.class)
    public ResponseEntity<Object> handleUserAlreadyCreatedException(
            UserAlreadyCreatedException ex, WebRequest request){
        return new ResponseEntity<>(
                new ErrorMessage(ex.getMessage(),ex.getPayload()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFound(
            UserNotFoundException ex, WebRequest request
    ){
        return new ResponseEntity<>(
                new ErrorMessage(ex.getMessage(),ex.getPayload()),
                HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List payload = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> {
                    return new  Pair(x.getField(),x.getDefaultMessage());
                })
                .collect(Collectors.toList());
        String errorMessage = "There is a problem with the fields format.";

        return new ResponseEntity<>(
                new ErrorMessage(errorMessage,payload),
                HttpStatus.BAD_REQUEST);
    }
}
