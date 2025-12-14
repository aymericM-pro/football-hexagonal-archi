package com.app.footballapispring.core.errors;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final BusinessError error;

    public BusinessException(BusinessError error) {
        super(error.getMessage());
        this.error = error;
    }

    public BusinessException(BusinessError error, String details) {
        super(error.getMessage() + " – " + details);
        this.error = error;
    }
}