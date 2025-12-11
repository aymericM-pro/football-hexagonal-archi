package com.app.footballapispring.football.domain.rounday.useCases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.rounday.RoundDay;
import com.app.footballapispring.football.domain.rounday.RoundDayRepository;
import com.app.footballapispring.football.domain.rounday.commands.RemoveFixtureFromRoundDayCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RemoveFixtureFromRoundDayUseCase implements CommandHandler<RemoveFixtureFromRoundDayCommand, Void> {

    private final RoundDayRepository repository;

    @Override
    public Void handle(RemoveFixtureFromRoundDayCommand cmd) {

        RoundDay rd = repository.findById(cmd.roundDayId())
                .orElseThrow(() -> new IllegalArgumentException("RoundDay not found: " + cmd.roundDayId()));

        rd.removeFixture(cmd.fixtureId());

        repository.save(rd);

        return null;
    }
}
