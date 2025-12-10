package com.app.footballapispring.football.application.rest.championship.requests;


public record AddTeamToChampionshipRequest(
        String championshipId,
        String teamId
) {}

