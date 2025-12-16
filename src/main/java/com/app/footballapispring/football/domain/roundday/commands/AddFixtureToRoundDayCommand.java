package com.app.footballapispring.football.domain.roundday.commands;

import com.app.footballapispring.core.mediator.Command;

import java.time.LocalDateTime;

public record AddFixtureToRoundDayCommand(
        String championshipId,
        String roundDayId,
        String homeTeamId,
        String awayTeamId,
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
) implements Command<Void> {}
