package com.app.footballapispring.football.domain.teams;

import com.app.footballapispring.core.mediator.Query;

public record GetTeamDetailsQuery(int id) implements Query<TeamDetail> {}
