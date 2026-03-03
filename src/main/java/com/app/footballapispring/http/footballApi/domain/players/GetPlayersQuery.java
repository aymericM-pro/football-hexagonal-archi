package com.app.footballapispring.http.footballApi.domain.players;

import com.app.footballapispring.core.mediator.Query;

import java.util.List;

public record GetPlayersQuery(int team, int season, int page) implements Query<List<Player>> {}
