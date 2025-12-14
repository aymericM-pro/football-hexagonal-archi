package com.app.footballapispring.core.errors.exceptions;

import com.app.footballapispring.core.errors.BusinessError;

public enum UserError implements BusinessError {

    USER_NOT_FOUND(404, "USER_NOT_FOUND", "User not found"),
    EMAIL_REQUIRED(400, "EMAIL_REQUIRED", "Email is required"),
    PASSWORD_REQUIRED(400, "PASSWORD_REQUIRED", "Password is required"),
    EMAIL_ALREADY_EXISTS(409, "EMAIL_ALREADY_EXISTS", "This email is already registered"),
    INVALID_CREDENTIALS(401, "INVALID_CREDENTIALS", "Invalid email or password"),
    UNAUTHORIZED(401, "UNAUTHORIZED", "You are not authorized to access this resource");

    private final int status;
    private final String code;
    private final String message;

    UserError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override public int getHttpStatus() { return status; }
    @Override public String getCode() { return code; }
    @Override public String getMessage() { return message; }
}
