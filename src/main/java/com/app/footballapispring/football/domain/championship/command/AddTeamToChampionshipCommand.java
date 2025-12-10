package com.app.footballapispring.football.domain.championship.command;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.championship.Championship;

public record AddTeamToChampionshipCommand(
        String championshipId,
        String teamId
) implements Command<Championship> {}
