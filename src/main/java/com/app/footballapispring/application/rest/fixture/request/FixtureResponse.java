package com.app.footballapispring.application.rest.fixture.request;

import java.time.LocalDateTime;

public record FixtureResponse(
        String id,
        String homeTeamId,
        String awayTeamId,
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
) {}