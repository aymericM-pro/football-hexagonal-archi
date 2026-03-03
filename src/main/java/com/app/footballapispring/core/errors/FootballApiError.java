package com.app.footballapispring.core.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum FootballApiError {

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "Invalid or missing API key"),
    PAYMENT_REQUIRED(HttpStatus.PAYMENT_REQUIRED, "PAYMENT_REQUIRED", "Subscription missing or expired"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "FORBIDDEN", "Insufficient permissions for this resource"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND", "Resource not found"),
    TIMEOUT(HttpStatus.TOO_MANY_REQUESTS, "TIMEOUT", "API-Sports timed out or rate-limit reached"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", "API-Sports returned an internal error");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    FootballApiError(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public static FootballApiError fromHttpStatus(HttpStatus status) {
        for (FootballApiError e : values()) {
            if (e.httpStatus == status) return e;
        }
        return INTERNAL_ERROR;
    }
}