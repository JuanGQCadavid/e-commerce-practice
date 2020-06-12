package com.ecommercepractice.productservice.exception;

import com.ecommercepractice.utilities.exception.GeneralExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Handle all errors relate to products Exceptions
 * returning a Entity response with a ErrorMessage Entity as body
 * Appending the corresponding http failure status
 */
@ControllerAdvice
public class ControllerAdvisor extends GeneralExceptionHandler {

}
