package com.app.footballapispring.football.domain.fixture.commands;

import com.app.footballapispring.core.mediator.Command;

public record DeleteFixtureCommand(String id) implements Command<Void> {}
