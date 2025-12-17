package com.app.footballapispring.core.errors.exceptions;

import com.app.footballapispring.core.errors.BusinessError;

public enum FixtureError implements BusinessError {

    FIXTURE_NOT_FOUND(404, "FIXTURE_NOT_FOUND", "Fixture not found"),
    INVALID_FIXTURE_DATE(400, "INVALID_FIXTURE_DATE", "Fixture date is invalid"),
    SAME_TEAM_FIXTURE(400, "SAME_TEAM_FIXTURE", "Home and away teams cannot be the same"),
    FIXTURE_ALREADY_PLAYED(409, "FIXTURE_ALREADY_PLAYED", "Fixture has already been played");

    private final int status;
    private final String code;
    private final String message;

    FixtureError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override public int getHttpStatus() { return status; }
    @Override public String getCode() { return code; }
    @Override public String getMessage() { return message; }
}