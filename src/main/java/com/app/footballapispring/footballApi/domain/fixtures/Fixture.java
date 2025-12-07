package com.app.footballapispring.footballApi.domain.fixtures;

public record Fixture(
        long id,
        String date,
        String status,
        String homeTeam,
        int homeGoals,
        String awayTeam,
        int awayGoals
) {}