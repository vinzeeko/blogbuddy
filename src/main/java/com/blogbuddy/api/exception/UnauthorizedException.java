package com.blogbuddy.api.exception;

import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    private final int status;

    public UnauthorizedException(final String message, final int status) {
        super(message);
        this.status = status;
    }
}
