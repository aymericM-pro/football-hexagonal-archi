package com.app.footballapispring.core.error.exceptions;

import com.app.footballapispring.core.error.BusinessError;

public enum TeamError implements BusinessError {

    TEAM_NOT_FOUND(404, "TEAM_NOT_FOUND", "Team not found"),
    PLAYER_NOT_FOUND(404, "PLAYER_NOT_FOUND", "Player not found"),
    PLAYER_ALREADY_IN_TEAM(409, "PLAYER_ALREADY_IN_TEAM", "Player is already in this team"),
    TEAM_NAME_REQUIRED(400, "TEAM_NAME_REQUIRED", "Team name is required"),
    COUNTRY_REQUIRED(400, "COUNTRY_REQUIRED", "Team country is required"),
    TEAM_FULL(400, "TEAM_FULL", "This team already has the maximum number of players");

    private final int status;
    private final String code;
    private final String message;

    TeamError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override public int getHttpStatus() { return status; }
    @Override public String getCode() { return code; }
    @Override public String getMessage() { return message; }
}
