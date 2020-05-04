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

/**
 * Intercepts the erros occurred during the ejection time and map them
 * to be send it to the user that perform the call indicating the problem
 * itself
 */
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    /**
     * The user already exist exception.
     * @param ex
     * @return
     */
    @ExceptionHandler(UserAlreadyCreatedException.class)
    public ResponseEntity<Object> handleUserAlreadyCreatedException(UserAlreadyCreatedException ex){
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(),ex.getPayload()),HttpStatus.CONFLICT);
    }

    /**
     * user doesn't exists exception.
     * It is throwed when performing Update, delete or get
     * @param ex
     * @return
     */

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFound(UserNotFoundException ex){
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(),ex.getPayload()), HttpStatus.NOT_FOUND);
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
                    return new  Pair(x.getField(),x.getDefaultMessage());
                })
                .collect(Collectors.toList());
        String errorMessage = "There is a problem with the fields format.";

        return new ResponseEntity<>(
                new ErrorMessage(errorMessage,payload),
                HttpStatus.BAD_REQUEST);
    }
}
