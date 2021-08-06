package com.blogbuddy.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private int statusCode;

    private long timestamp;

    private String message;

    private String cause;

    private List<String> errors;

    public ErrorMessage(int statusCode, long timestamp, String message) {
        this(statusCode, timestamp, message, null, null);
    }

    public ErrorMessage(int statusCode, long timestamp, String message, String cause) {
        this(statusCode, timestamp, message, cause, null);
    }

    public ErrorMessage(int status, long timestamp, String message, String cause, List<String> errors) {
        this.statusCode = status;
        this.timestamp = timestamp;
        this.message = message;
        this.cause = cause;
        this.errors = errors;
    }
}

