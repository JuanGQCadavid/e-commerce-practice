package com.ecommercepractice.authentication.exception;

import com.ecommercepractice.authentication.util.Pair;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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

    ErrorType errorType;

    /**
     * The email that is attempting to save on the system
     * is already in use by other Ath
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<Object> handleEmailAlreadyUsedException(
            EmailAlreadyUsedException ex,
            WebRequest request
    ){
        return new ResponseEntity<>(
            new ErrorMessage(ex.getMessage(),errorType.EMAIL_ALREADY_USED,ex.getPayload()),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }


    /**
     * The email does not exist on the system register.
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<Object> handleEmailNotFoundException(
            EmailNotFoundException ex,
            WebRequest request
    ){
        return new ResponseEntity(
                new ErrorMessage(ex.getMessage(),errorType.EMAIL_NOT_FOUND, ex.getPayload()),
                HttpStatus.NOT_FOUND
        );
    }

    /**
     * The token of Auth has is already expired
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ExpiredUserTokenException.class)
    public ResponseEntity<Object> handleExpiredUserToken(
            ExpiredUserTokenException ex,
            WebRequest request
    ){
        return new ResponseEntity<>(
                new ErrorMessage(ex.getMessage(),errorType.EXPIRED_TOKEN,ex.getPayload()),
                HttpStatus.FORBIDDEN
        );
    }

    /**
     * The User email exist but the password associated to the email
     * is wrong.
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(InvalidUserPasswordException.class)
    public ResponseEntity<ErrorMessage> handleInvalidUserPassword(
            InvalidUserPasswordException ex,
            WebRequest request
    ){
        return new ResponseEntity(
                new ErrorMessage(ex.getMessage(),errorType.INVALID_PASSWORD, ex.getPayload()),
                HttpStatus.UNAUTHORIZED
        );
    }

    /**
     * The token exist, but it is not attached to the current email.
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(InvalidUserTokenException.class)
    public ResponseEntity<Object> handleInvalidUserToken(
            InvalidUserTokenException ex,
            WebRequest request
    ){
        return new ResponseEntity<>(
                new ErrorMessage(ex.getMessage(),errorType.INVALID_TOKEN,ex.getPayload()),
                HttpStatus.UNAUTHORIZED
        );
    }

    /**
     * Token does not exist on the database.
     * @param ex
     * @param request
     * @return
     */

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<Object> handleTokenNotFound(
            TokenNotFoundException ex,
            WebRequest request
    ){
        return new ResponseEntity<>(
                new ErrorMessage(ex.getMessage(),errorType.TOKEN_NO_FOUND,ex.getPayload()),
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
                new ErrorMessage(errorMessage,errorType.MISSING_FIELDS,payload),
                HttpStatus.BAD_REQUEST);
    }

}
