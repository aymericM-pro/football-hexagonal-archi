package com.app.footballapispring.football.domain.championship.command;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.championship.Championship;

public record InitializeChampionshipCalendarCommand(
        String championshipId
) implements Command<Championship> {
}
