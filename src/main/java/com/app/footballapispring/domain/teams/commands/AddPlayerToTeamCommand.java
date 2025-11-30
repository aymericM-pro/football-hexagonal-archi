package com.app.footballapispring.domain.teams.commands;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.domain.teams.Team;

public record AddPlayerToTeamCommand(
        String teamId,
        String playerId
) implements Command<Team> {}
