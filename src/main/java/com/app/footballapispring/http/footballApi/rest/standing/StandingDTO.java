package com.app.footballapispring.http.footballApi.rest.standing;

public record StandingDTO(
        int rank,
        int teamId,
        String teamName,
        int points,
        int played,
        int win,
        int draw,
        int lose,
        int goalsFor,
        int goalsAgainst,
        int goalsDiff
) {}