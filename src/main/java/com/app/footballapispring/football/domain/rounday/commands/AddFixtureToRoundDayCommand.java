package com.app.footballapispring.football.domain.rounday.commands;

import com.app.footballapispring.core.mediator.Command;

import java.time.LocalDateTime;

public record AddFixtureToRoundDayCommand(
        String roundDayId,
        String homeTeamId,
        String awayTeamId,
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
) implements Command<Void> {}
