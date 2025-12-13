package com.app.footballapispring.football.domain.championship.command;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.teams.Team;

import java.util.List;

public record GetTeamsOfChampionshipQuery(
        String championshipId
) implements Query<List<Team>> {
}
