package com.as._3.realtimeorderprocessing.infrastructure.exceptions;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ExceptionsHandle {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ExceptionResponse> orderNotFoundExceptionHandle(OrderNotFoundException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                request.getDescription(false),
                new Date()
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
