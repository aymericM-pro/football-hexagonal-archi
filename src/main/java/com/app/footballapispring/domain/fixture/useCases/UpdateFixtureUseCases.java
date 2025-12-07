package com.app.footballapispring.domain.fixture.useCases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.domain.fixture.Fixture;
import com.app.footballapispring.domain.fixture.FixtureRepository;
import com.app.footballapispring.domain.fixture.commands.UpdateFixtureCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateFixtureUseCases implements CommandHandler<UpdateFixtureCommand, Fixture> {

    private final FixtureRepository repository;

    @Override
    public Fixture handle(UpdateFixtureCommand command) {

        Fixture existing = repository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Fixture not found"));

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
