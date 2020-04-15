package com.ecommercepractice.authentication.exception;

import com.ecommercepractice.authentication.util.Pair;
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
    final String EMAILALREADYUSED = "EmailAlreadyUsedException";
    final String EMAILNOTFOUND = "EmailNotFoundException";
    final String INVALIDPASSWORD = "InvalidUserPasswordException";
    final String MISSINGFIELDS = "MissingFieldsBody";

    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<Object> handleEmailAlreadyUsedException(
            EmailAlreadyUsedException ex,
            WebRequest request
    ){
        return new ResponseEntity<>(
            new ErrorMessage(ex.getMessage(),EMAILALREADYUSED,ex.getPayload()),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<Object> handleEmailNotFoundException(
            EmailNotFoundException ex,
            WebRequest request
    ){
        return new ResponseEntity(
                new ErrorMessage(ex.getMessage(),EMAILNOTFOUND, ex.getPayload()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InvalidUserPasswordException.class)
    public ResponseEntity<ErrorMessage> handleInvalidUserPassword(
            InvalidUserPasswordException ex,
            WebRequest request
    ){
        return new ResponseEntity(
                new ErrorMessage(ex.getMessage(),INVALIDPASSWORD, ex.getPayload()),
                HttpStatus.UNAUTHORIZED
        );
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

        return new ResponseEntity<>(
                new ErrorMessage(errorMessage,MISSINGFIELDS,payload),
                HttpStatus.BAD_REQUEST);
    }

}
