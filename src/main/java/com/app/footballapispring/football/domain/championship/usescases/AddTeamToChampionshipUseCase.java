package com.app.footballapispring.football.domain.championship.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.command.AddTeamToChampionshipCommand;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddTeamToChampionshipUseCase
        implements CommandHandler<AddTeamToChampionshipCommand, Championship> {

    private final ChampionshipRepository championshipRepo;
    private final TeamRepository teamRepo;

    @Override
    public Championship handle(AddTeamToChampionshipCommand cmd) {

        Championship championship = championshipRepo.findById(cmd.championshipId())
                .orElseThrow(() -> new IllegalStateException("Championship not found"));

        Team team = teamRepo.findById(cmd.teamId())
                .orElseThrow(() -> new IllegalStateException("Team not found"));

        championship.addTeam(team);

        return championshipRepo.save(championship);
    }
}
