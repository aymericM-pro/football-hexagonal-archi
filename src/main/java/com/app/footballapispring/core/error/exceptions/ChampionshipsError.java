package com.app.footballapispring.core.error.exceptions;

import com.app.footballapispring.core.error.BusinessError;

public enum ChampionshipsError implements BusinessError {
    CHAMPIONSHIP_NOT_FOUND(404, "CHAMPIONSHIP_NOT_FOUND", "Championship not found"),

    TEAM_ALREADY_REGISTERED(
            409,
            "CHAMPIONSHIP_TEAM_ALREADY_REGISTERED",
            "Team already registered in championship"
    ),

    MAX_TEAMS_REACHED(
            409,
            "CHAMPIONSHIP_MAX_TEAMS_REACHED",
            "Maximum number of teams reached for this championship"
    ),

    TEAMS_NUMBER_MUST_BE_EVEN(
            400,
            "CHAMPIONSHIP_TEAMS_NUMBER_MUST_BE_EVEN",
            "Number of teams in a championship must be even"
    );

    private final int status;
    private final String code;
    private final String message;

    ChampionshipsError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override public int getHttpStatus() { return status; }
    @Override public String getCode() { return code; }
    @Override public String getMessage() { return message; }
}
