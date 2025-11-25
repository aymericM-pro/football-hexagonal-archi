package com.app.footballapispring;

public record TeamStanding(
        int position,       // rang dans le classement
        int teamId,         // nouvel ID de l'équipe
        String teamName,    // nom de l'équipe
        int points,
        int played,
        int wins,
        int draws,
        int losses,
        int goalsFor,
        int goalsAgainst,
        int goalDiff
) {}
