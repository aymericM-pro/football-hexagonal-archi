package com.app.footballapispring.football.domain.championship.usescases;

import com.app.footballapispring.core.error.BusinessException;
import com.app.footballapispring.core.error.exceptions.ChampionshipsError;
import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.command.GetTeamsOfChampionshipQuery;
import com.app.footballapispring.football.domain.teams.Team;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetTeamsOfChampionshipUseCase
        implements QueryHandler<GetTeamsOfChampionshipQuery, List<Team>> {

    private final ChampionshipRepository championshipRepository;

    @Override
    public List<Team> handle(GetTeamsOfChampionshipQuery query) {

        Championship championship = championshipRepository
                .findById(query.championshipId())
                .orElseThrow(() -> new BusinessException(
                        ChampionshipsError.CHAMPIONSHIP_NOT_FOUND
                ));

        return championship.getTeams();
    }
}
