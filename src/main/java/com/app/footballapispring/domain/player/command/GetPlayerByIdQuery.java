package com.app.footballapispring.domain.player.command;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.domain.player.Player;

public record GetPlayerByIdQuery(String id) implements Query<Player> {}
