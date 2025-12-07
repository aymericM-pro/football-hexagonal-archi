package com.app.footballapispring.football.domain.teams.usescases;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import com.app.footballapispring.football.domain.teams.commands.GetAllTeamsQuery;

import java.util.List;

public class GetAllTeamUseCase implements QueryHandler<GetAllTeamsQuery, List<Team>> {

    private final TeamRepository repo;

    public GetAllTeamUseCase(TeamRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Team> handle(GetAllTeamsQuery query) {
        return repo.findAll();
    }
}
