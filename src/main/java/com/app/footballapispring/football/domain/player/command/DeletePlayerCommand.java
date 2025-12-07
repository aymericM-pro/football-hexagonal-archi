package com.app.footballapispring.football.domain.player.command;

import com.app.footballapispring.core.mediator.Command;

public record DeletePlayerCommand(String id) implements Command<Void> {}
