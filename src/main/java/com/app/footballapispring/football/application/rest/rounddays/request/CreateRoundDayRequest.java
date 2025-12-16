package com.app.footballapispring.football.application.rest.rounddays.request;

public record CreateRoundDayRequest(
        String championshipId,
        int number
) {}
