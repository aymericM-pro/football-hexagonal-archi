package com.app.footballapispring.domain.teams.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.domain.teams.Team;

public record GetTeamByIdQuery(String id) implements Query<Team> {}
