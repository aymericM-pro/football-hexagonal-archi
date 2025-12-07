package com.app.footballapispring.football.domain.fixture.useCases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.fixture.FixtureRepository;
import com.app.footballapispring.football.domain.fixture.commands.DeleteFixtureCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteFixtureUseCase implements CommandHandler<DeleteFixtureCommand, Void> {

    private final FixtureRepository repository;

    @Override
    public Void handle(DeleteFixtureCommand cmd) {
        repository.delete(cmd.id());
        return null;
    }
}
