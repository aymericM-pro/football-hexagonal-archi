package com.app.footballapispring.football.application.rest.fixture.request;

import java.time.LocalDateTime;

public record FixtureResponse(
        String id,
        String homeTeamId,
        String awayTeamId,
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
) {}