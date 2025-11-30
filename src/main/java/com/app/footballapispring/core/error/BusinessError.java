package com.app.footballapispring.core.error;

public interface BusinessError {
    int getHttpStatus();
    String getCode();
    String getMessage();
}
