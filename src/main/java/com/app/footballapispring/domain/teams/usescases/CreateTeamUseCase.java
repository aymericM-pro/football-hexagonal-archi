package com.app.footballapispring.domain.teams.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.domain.teams.Team;
import com.app.footballapispring.domain.teams.TeamRepository;
import com.app.footballapispring.domain.teams.commands.CreateTeamCommand;

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
