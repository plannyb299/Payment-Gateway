package com.nyamita.paymentgateway.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExeptionResponseHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  protected ResponseEntity<Object> exception(BadRequestException exception) {

    ErrorMessage errorMsg = new ErrorMessage(exception.getMessage(), 404, "range not defined");
    return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RecordNotFoundException.class)
  protected ResponseEntity<Object> exception(RecordNotFoundException exception) {

    ErrorMessage errorMsg = new ErrorMessage(exception.getMessage(), 404, "Record not available");
    return new ResponseEntity<>(errorMsg, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
  }

}


