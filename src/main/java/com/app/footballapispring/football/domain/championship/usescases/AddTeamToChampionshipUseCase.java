package com.app.footballapispring.football.domain.championship.usescases;

import com.app.footballapispring.core.errors.BusinessException;
import com.app.footballapispring.core.errors.exceptions.ChampionshipsError;
import com.app.footballapispring.core.errors.exceptions.TeamError;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.teams.Team;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.championship.command.AddTeamToChampionshipCommand;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class AddTeamToChampionshipUseCase
        implements CommandHandler<AddTeamToChampionshipCommand, Championship> {

    private final ChampionshipRepository championshipRepo;
    private final TeamRepository teamRepo;

    @Override
    @Transactional
    public Championship handle(AddTeamToChampionshipCommand cmd) {

        Championship championship = championshipRepo.findById(cmd.championshipId())
                .orElseThrow(() ->
                        new BusinessException(
                                ChampionshipsError.CHAMPIONSHIP_NOT_FOUND
                        )
                );

        Team team = teamRepo.findById(cmd.teamId())
                .orElseThrow(() ->
                        new BusinessException(
                                TeamError.TEAM_NOT_FOUND
                        )
                );

        // logique métier
        championship.addTeam(team);

        // 🔥 persistance relation (OBLIGATOIRE)
        teamRepo.addTeamToChampionship(team.getId(), championship.getId());

        return championship;
    }

}
