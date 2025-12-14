package com.app.footballapispring.core.errors;

import lombok.Getter;

@Getter
public enum FootballApiError {

    UNAUTHORIZED(401, "UNAUTHORIZED", "Invalid or missing API key"),
    PAYMENT_REQUIRED(402, "PAYMENT_REQUIRED", "Subscription missing or expired"),
    FORBIDDEN(403, "FORBIDDEN", "Insufficient permissions for this resource"),
    NOT_FOUND(404, "NOT_FOUND", "Resource not found"),
    TIMEOUT(499, "TIMEOUT", "API-Sports timed out or rate-limit reached"),
    INTERNAL_ERROR(500, "INTERNAL_ERROR", "API-Sports returned an internal error");

    private final int httpStatus;
    private final String code;
    private final String message;

    FootballApiError(int httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public static FootballApiError fromHttpStatus(int status) {
        for (FootballApiError e : values()) {
            if (e.httpStatus == status) return e;
        }
        return INTERNAL_ERROR;
    }
}
