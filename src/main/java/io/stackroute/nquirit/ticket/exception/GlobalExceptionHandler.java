package io.stackroute.nquirit.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    ResponseEntity responseEntity;
    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<String> notFoundException(final TicketNotFoundException e){
        return responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
