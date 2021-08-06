package com.blogbuddy.api.exception;

public class CreateException extends RuntimeException {
    public CreateException(final String message, final Exception ex) {
        super(message, ex);
    }

    public CreateException(final String message) {
        super(message);
    }
}
