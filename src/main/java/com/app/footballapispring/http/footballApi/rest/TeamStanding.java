package com.app.footballapispring.http.footballApi.rest;

public record TeamStanding(
        int position,
        int teamId,
        String teamName,
        int points,
        int played,
        int wins,
        int draws,
        int losses,
        int goalsFor,
        int goalsAgainst,
        int goalDiff
) {}
