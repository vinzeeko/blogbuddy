package com.blogbuddy.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Not Found");
    }

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final String message, final Exception e) {
        super(message, e);
    }
}
