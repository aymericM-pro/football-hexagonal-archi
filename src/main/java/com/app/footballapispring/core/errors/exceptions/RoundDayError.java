package com.app.footballapispring.core.errors.exceptions;

import com.app.footballapispring.core.errors.BusinessError;

public enum RoundDayError implements BusinessError {

    ROUND_DAY_NOT_FOUND(404, "ROUND_DAY_NOT_FOUND", "Round day not found"),
    FIXTURE_NOT_IN_ROUND_DAY(404, "FIXTURE_NOT_IN_ROUND_DAY", "Fixture not found in this round day"),
    INVALID_ROUND_NUMBER(400, "INVALID_ROUND_NUMBER", "Round number must be positive"),
    ROUND_DAY_ALREADY_EXISTS(409, "ROUND_DAY_ALREADY_EXISTS", "Round day already exists for this championship");

    private final int status;
    private final String code;
    private final String message;

    RoundDayError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override public int getHttpStatus() { return status; }
    @Override public String getCode() { return code; }
    @Override public String getMessage() { return message; }
}
