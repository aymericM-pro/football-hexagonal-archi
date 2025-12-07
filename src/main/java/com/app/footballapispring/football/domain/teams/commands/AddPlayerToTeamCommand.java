package com.app.footballapispring.football.domain.teams.commands;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.football.domain.teams.Team;

public record AddPlayerToTeamCommand(
        String teamId,
        String playerId
) implements Command<Team> {}
