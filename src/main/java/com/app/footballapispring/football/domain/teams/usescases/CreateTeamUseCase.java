package com.app.footballapispring.football.domain.teams.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import com.app.footballapispring.football.domain.teams.commands.CreateTeamCommand;

public class CreateTeamUseCase implements CommandHandler<CreateTeamCommand, Team> {

    private final TeamRepository repo;

    public CreateTeamUseCase(TeamRepository repo) {
        this.repo = repo;
    }

    @Override
    public Team handle(CreateTeamCommand c) {
        Team t = new Team(
                null,
                c.name(),
                c.country()
        );

        return repo.save(t);
    }
}
