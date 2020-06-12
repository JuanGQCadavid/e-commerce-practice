package com.ecommercepractice.userservice.exception;

import com.ecommercepractice.utilities.exception.GeneralExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Intercepts the erros occurred during the ejection time and map them
 * to be send it to the user that perform the call indicating the problem
 * itself
 */
@ControllerAdvice
public class ControllerAdvisor extends GeneralExceptionHandler {
}
