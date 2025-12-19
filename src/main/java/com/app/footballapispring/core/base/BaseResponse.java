package com.app.footballapispring.core.base;

import java.time.LocalDateTime;

public record BaseResponse<T>(
        int status,
        String message,
        LocalDateTime timestamp,
        T data
) {
    public BaseResponse {
        timestamp = LocalDateTime.now();
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(200, "Success", LocalDateTime.now(), data);
    }

    public static <T> BaseResponse<T> created(T data) {
        return new BaseResponse<>(201, "Created", LocalDateTime.now(), data);
    }
}
