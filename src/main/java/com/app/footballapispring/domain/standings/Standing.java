package com.app.footballapispring.domain.standings;

public record Standing(
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
