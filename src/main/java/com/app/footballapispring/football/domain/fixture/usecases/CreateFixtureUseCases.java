package com.app.footballapispring.football.domain.fixture.usecases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.fixture.FixtureRepository;
import com.app.footballapispring.football.domain.fixture.commands.CreateFixtureCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateFixtureUseCases implements CommandHandler<CreateFixtureCommand, Fixture> {

    private final FixtureRepository repo;

    @Override
    public Fixture handle(CreateFixtureCommand cmd) {

        Fixture m = new Fixture(
                cmd.homeTeamId(),
                cmd.awayTeamId(),
                cmd.homeScore(),
                cmd.awayScore(),
                cmd.date()
        );

        return repo.save(m);
    }
}
