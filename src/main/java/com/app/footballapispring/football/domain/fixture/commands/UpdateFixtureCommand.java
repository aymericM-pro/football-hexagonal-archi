package com.app.footballapispring.football.domain.fixture.commands;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.fixture.Fixture;

import java.time.LocalDateTime;

public record UpdateFixtureCommand(
        String id,
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
) implements Command<Fixture> {
}
