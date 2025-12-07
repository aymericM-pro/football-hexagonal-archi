package com.app.footballapispring.football.domain.player.command;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.player.Player;

import java.util.List;

public record GetAllPlayersQuery() implements Query<List<Player>> {}
