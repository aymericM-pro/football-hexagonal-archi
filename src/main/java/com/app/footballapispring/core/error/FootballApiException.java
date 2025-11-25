package com.app.footballapispring.core;

public class FootballApiException extends RuntimeException {

    private final FootballApiError error;

    public FootballApiException(FootballApiError error) {
        super(error.getMessage());
        this.error = error;
    }

    public FootballApiException(FootballApiError error, String details) {
        super(error.getMessage() + " - " + details);
        this.error = error;
    }

    public FootballApiError getError() {
        return error;
    }
}
