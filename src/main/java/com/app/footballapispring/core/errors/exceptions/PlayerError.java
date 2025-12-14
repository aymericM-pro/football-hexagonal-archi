package com.app.footballapispring.core.errors.exceptions;

import com.app.footballapispring.core.errors.BusinessError;

public enum PlayerError implements BusinessError  {
    PLAYER_NOT_FOUND(404, "PLAYER_NOT_FOUND", "Player not found");

    private final int status;
    private final String code;
    private final String message;

    PlayerError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override public int getHttpStatus() { return status; }
    @Override public String getCode() { return code; }
    @Override public String getMessage() { return message; }
}
