package com.app.footballapispring.core.errors;

import org.springframework.http.HttpStatus;

public interface BusinessError {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}