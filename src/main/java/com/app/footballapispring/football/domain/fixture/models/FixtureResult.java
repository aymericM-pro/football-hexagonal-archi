package com.app.footballapispring.football.domain.fixture.models;

public record FixtureResult(
        String id,
        String homeTeamId,
        String awayTeamId,
        Integer homeScore,
        Integer awayScore
) {}
