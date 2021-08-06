package com.blogbuddy.api.controller;

import com.blogbuddy.api.exception.CreateException;
import com.blogbuddy.api.exception.ErrorMessage;
import com.blogbuddy.api.exception.UnauthorizedException;
import com.blogbuddy.api.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class RestExceptionMapper {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorMessage> handle(final UnauthorizedException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorMessage(ex.getStatus(), System.currentTimeMillis(), ex.getMessage()));
    }

    @ExceptionHandler(CreateException.class)
    public ResponseEntity<ErrorMessage> handle(final CreateException ex) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis(), ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handle(final IllegalArgumentException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(BAD_REQUEST)
                .body(new ErrorMessage(BAD_REQUEST.value(), System.currentTimeMillis(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handle(final Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis(), ex.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handle(final ResourceNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(NOT_FOUND)
                .body(new ErrorMessage(NOT_FOUND.value(), System.currentTimeMillis(), ex.getMessage()));
    }

}
