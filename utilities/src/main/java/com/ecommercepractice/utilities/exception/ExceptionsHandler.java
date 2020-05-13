package com.ecommercepractice.utilities.exception;

import com.ecommercepractice.utilities.util.Pair;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    /**
     * General error handler for all the Order exceptions family.
     * @param ex
     * @return
     */
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorMessage> orderExceptionsHandler(GeneralException ex){
        log.error(ex.getMessage());
        return new ResponseEntity( new ErrorMessage(ex), ex.getErrorType().getStatus());
    }

    /**
     * This method handle when the user body is missing some arguments that
     * are required by the actual contract of the API
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List payload = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> {
                    return new Pair(x.getField(),x.getDefaultMessage());
                })
                .collect(Collectors.toList());
        String errorMessage = "There is a problem with the fields format.";

        return new ResponseEntity<>(new ErrorMessage(errorMessage,ErrorType.MISSING_FIELDS,payload),ErrorType.MISSING_FIELDS.getStatus());
    }
}
