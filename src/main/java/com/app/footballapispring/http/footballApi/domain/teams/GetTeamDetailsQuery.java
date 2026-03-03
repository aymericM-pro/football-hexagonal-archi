package com.app.footballapispring.http.footballApi.domain.teams;

import com.app.footballapispring.core.mediator.Query;

public record GetTeamDetailsQuery(int id) implements Query<TeamDetail> {}
