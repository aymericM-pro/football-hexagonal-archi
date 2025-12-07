package com.app.footballapispring.domain.fixture.useCases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.domain.fixture.Fixture;
import com.app.footballapispring.domain.fixture.FixtureRepository;
import com.app.footballapispring.domain.fixture.commands.CreateFixtureCommand;
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
