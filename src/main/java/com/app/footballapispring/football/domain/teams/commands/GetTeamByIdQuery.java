package com.app.footballapispring.football.domain.teams.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.teams.Team;

public record GetTeamByIdQuery(String id) implements Query<Team> {}
