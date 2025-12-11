package com.app.footballapispring.football.domain.rounday.commands;

import com.app.footballapispring.core.mediator.Command;

public record RemoveFixtureFromRoundDayCommand(
        String roundDayId,
        String fixtureId
) implements Command<Void> {}