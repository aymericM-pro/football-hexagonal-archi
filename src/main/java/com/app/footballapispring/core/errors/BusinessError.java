package com.app.footballapispring.core.errors;

public interface BusinessError {
    int getHttpStatus();
    String getCode();
    String getMessage();
}
