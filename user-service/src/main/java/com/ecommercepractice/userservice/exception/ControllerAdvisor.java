package com.ecommercepractice.userservice.exception;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyCreatedException.class)
    public ResponseEntity<Object> handleUserAlreadyCreatedException(
            UserAlreadyCreatedException ex, WebRequest request){

        JSONObject body = new JSONObject();

        body.put("timestamp", LocalDateTime.now());
        body.put("status","error");

        JSONObject err_msg = new JSONObject();
        err_msg.put("msg",ex.getMessage());
        err_msg.put("user_data", ex.getBadUser());

        body.put("error", err_msg);

        return new ResponseEntity<>(body.toMap(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFound(
            UserNotFoundException ex, WebRequest request
    ){
        JSONObject body = new JSONObject();

        body.put("timestamp", LocalDateTime.now());
        body.put("status","error");

        JSONObject err_msg = new JSONObject();
        err_msg.put("msg",ex.getMessage());
        err_msg.put("user_id", ex.getBadUser());

        body.put("error", err_msg);

        System.out.println(body);

        return new ResponseEntity<>(body.toMap(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        JSONObject body = new JSONObject();
        body.put("timestamp", LocalDateTime.now());
        body.put("status","error");

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body.toMap(),HttpStatus.BAD_REQUEST);
    }
}
