package com.app.footballapispring.core.errors.exceptions;

import com.app.footballapispring.core.errors.BusinessError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum UserError implements BusinessError {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND", "User not found"),
    EMAIL_REQUIRED(HttpStatus.BAD_REQUEST, "EMAIL_REQUIRED", "Email is required"),
    PASSWORD_REQUIRED(HttpStatus.BAD_REQUEST, "PASSWORD_REQUIRED", "Password is required"),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "EMAIL_ALREADY_EXISTS", "This email is already registered"),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "INVALID_CREDENTIALS", "Invalid email or password"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "You are not authorized to access this resource");

    private final HttpStatus status;
    private final String code;
    private final String message;

    UserError(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }
}