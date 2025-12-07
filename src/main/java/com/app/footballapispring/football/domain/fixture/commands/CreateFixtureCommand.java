package com.app.footballapispring.football.domain.fixture.commands;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.fixture.Fixture;

import java.time.LocalDateTime;

public record CreateFixtureCommand(
        String homeTeamId,
        String awayTeamId,
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
) implements Command<Fixture> {
}
