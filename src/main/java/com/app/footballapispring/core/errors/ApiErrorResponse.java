package com.app.footballapispring.core.errors;

import java.time.Instant;
import java.util.Map;

public class ApiErrorResponse {

    private final String timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String details;
    private final Map<String, String> validationErrors;

    public ApiErrorResponse(int status,
                            String error,
                            String message,
                            String details,
                            Map<String, String> validationErrors) {
        this.timestamp = Instant.now().toString();
        this.status = status;
        this.error = error;
        this.message = message;
        this.details = details;
        this.validationErrors = validationErrors;
    }

    public String getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
    public String getDetails() { return details; }
    public Map<String, String> getValidationErrors() { return validationErrors; }
}