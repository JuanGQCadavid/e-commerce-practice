package com.ecommercepractice.stockservice.exception;

import com.ecommercepractice.stockservice.util.Pair;
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
public class StockErrorHandler extends ResponseEntityExceptionHandler {

    /**
     * General error handler for custom Stock's errors
     * @param ex
     * @return
     */
    @ExceptionHandler({
            StockNotFoundedException.class,
            StockProductAlreadyOnInventoryException.class,
            InsufficientStockException.class,
            StockFreezeInsufficientException.class
    })
    public ResponseEntity<Object> handleStockException(StockException ex){
        return new ResponseEntity<>(
                new ErrorMessage(ex.getMessage(),ex.getErrorType(),ex.getPayload()),
                ex.getErrorType().getStatus()
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
                new ErrorMessage(errorMessage,ErrorType.MISSING_FIELDS,payload), ErrorType.MISSING_FIELDS.getStatus());
    }
}