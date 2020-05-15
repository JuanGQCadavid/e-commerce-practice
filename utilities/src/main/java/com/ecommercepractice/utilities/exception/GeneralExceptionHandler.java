package com.ecommercepractice.utilities.exception;

import com.ecommercepractice.utilities.config.ConstantsWords;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * General error handler for all the Order exceptions family.
     * @param ex
     * @return
     */
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorMessage> orderExceptionsHandler(GeneralException ex){
        log.error(ex.getMessage());
        return new ResponseEntity( messageBuild(ex), ex.getGeneralErrorType().getStatus());
    }

    private ErrorMessage messageBuild(GeneralException ex){
        return ErrorMessage.builder()
                .message(ex.getMessage())
                .payload(ex.getPayload())
                .errorType(ex.getGeneralErrorType().getLabel())
                .timeStamp(LocalDateTime.now())
                .build();
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

        return new ResponseEntity(messageBuild(new MissingValuesException(payload)),HttpStatus.BAD_REQUEST);
    }
}
