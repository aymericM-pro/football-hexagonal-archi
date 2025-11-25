package com.app.footballapispring.domain.player;

import com.app.footballapispring.core.mediator.Query;

import java.util.List;

public record GetPlayersQuery(int teamId, int season, int page)
        implements Query<List<Player>> {}