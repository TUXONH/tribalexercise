package com.tribal.controllers;

import com.tribal.dto.ErrorResponse;
import com.tribal.exceptions.CreditLineFailException;
import com.tribal.exceptions.RequestLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController extends Throwable {

    @ExceptionHandler({RequestLimitException.class})
    public ResponseEntity<Object> requestLimitException(RequestLimitException exception) {
        ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.TOO_MANY_REQUESTS)
                .withMessage("Number of successful attempts")
                .withException(exception.getClass().getSimpleName())
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }
    @ExceptionHandler({CreditLineFailException.class})
    public ResponseEntity<Object> creditLineFailException(CreditLineFailException exception) {
        ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.BAD_REQUEST)
                .withMessage("A sales agent will contact you")
                .withException(exception.getClass().getSimpleName())
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }
}
