package com.app.footballapispring.football.domain.teams.usescases;


import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import com.app.footballapispring.football.domain.teams.commands.GetTeamByIdQuery;

public class GetTeamByIdUseCase implements QueryHandler<GetTeamByIdQuery, Team> {

    private final TeamRepository teamRepo;

    public GetTeamByIdUseCase(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Override
    public Team handle(GetTeamByIdQuery query) {
        return teamRepo.findById(query.id())
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }
}

