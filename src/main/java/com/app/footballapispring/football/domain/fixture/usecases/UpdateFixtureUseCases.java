package com.app.footballapispring.football.domain.fixture.usecases;

import com.app.footballapispring.core.errors.BusinessException;
import com.app.footballapispring.core.errors.exceptions.FixtureError;
import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.fixture.FixtureRepository;
import com.app.footballapispring.football.domain.fixture.commands.UpdateFixtureCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateFixtureUseCases implements CommandHandler<UpdateFixtureCommand, Fixture> {

    private final FixtureRepository repository;

    @Override
    public Fixture handle(UpdateFixtureCommand command) {

        Fixture existing = repository.findById(command.id())
                .orElseThrow(() -> new BusinessException(FixtureError.FIXTURE_NOT_FOUND));

        Fixture updated = new Fixture(
                existing.getId(),
                existing.getHomeTeamId(),
                existing.getAwayTeamId(),
                command.homeScore(),
                command.awayScore(),
                command.date()
        );

        return repository.save(updated);
    }
}
