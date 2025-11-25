package com.app.footballapispring.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FootballApiException.class)
    public ResponseEntity<?> handleFootballApi(FootballApiException ex) {

        FootballApiError error = ex.getError();

        Map<String, Object> body = Map.of(
                "timestamp", Instant.now().toString(),
                "error", error.getCode(),
                "message", error.getMessage(),
                "details", ex.getMessage(),
                "status", error.getHttpStatus()
        );

        return ResponseEntity
                .status(error.getHttpStatus())
                .body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnexpected(Exception ex) {

        Map<String, Object> body = Map.of(
                "timestamp", Instant.now().toString(),
                "error", "UNEXPECTED_ERROR",
                "message", ex.getMessage(),
                "status", 500
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
