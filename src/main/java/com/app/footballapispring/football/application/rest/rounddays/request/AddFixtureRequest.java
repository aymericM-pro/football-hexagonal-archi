package com.app.footballapispring.football.application.rest.rounddays.request;

import java.time.LocalDateTime;

public record AddFixtureRequest(
        String homeTeamId,
        String awayTeamId,
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
) {}