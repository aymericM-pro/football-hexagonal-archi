package com.app.footballapispring.domain.teams.usescases;

import com.app.footballapispring.core.error.BusinessException;
import com.app.footballapispring.core.error.exceptions.TeamError;
import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.PlayerRepository;
import com.app.footballapispring.domain.teams.Team;
import com.app.footballapispring.domain.teams.TeamRepository;
import com.app.footballapispring.domain.teams.commands.AddPlayerToTeamCommand;

public class AddPlayerToTeamUseCase implements CommandHandler<AddPlayerToTeamCommand, Team> {

    private final TeamRepository teamRepo;
    private final PlayerRepository playerRepo;

    public AddPlayerToTeamUseCase(TeamRepository teamRepo, PlayerRepository playerRepo) {
        this.teamRepo = teamRepo;
        this.playerRepo = playerRepo;
    }

    @Override
    public Team handle(AddPlayerToTeamCommand command) {

        Team team = teamRepo.findById(command.teamId())
                .orElseThrow(() -> new BusinessException(TeamError.TEAM_NOT_FOUND));

        if (team.getPlayers().size() >= 5) {
            throw new BusinessException(TeamError.TEAM_FULL);
        }

        Player player = playerRepo.findById(command.playerId())
                .orElseThrow(() -> new BusinessException(TeamError.PLAYER_NOT_FOUND));

        // 👉 Appelle une méthode “métiers” sans accès DB
        return teamRepo.addPlayer(team, player);
    }}
