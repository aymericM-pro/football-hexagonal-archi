package com.app.footballapispring.footballApi.rest.fixture;

public record FixtureDTO(
        long id,
        String date,
        String status,
        String homeTeam,
        int homeGoals,
        String awayTeam,
        int awayGoals
) {}
