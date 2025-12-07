package com.app.footballapispring.football.domain.player.command;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.player.Player;

public record GetPlayerByIdQuery(String id) implements Query<Player> {}
