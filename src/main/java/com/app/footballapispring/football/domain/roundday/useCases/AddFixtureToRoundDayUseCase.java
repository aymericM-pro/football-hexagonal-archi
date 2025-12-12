package com.app.footballapispring.football.domain.roundday.useCases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.domain.roundday.RoundDayRepository;
import com.app.footballapispring.football.domain.roundday.commands.AddFixtureToRoundDayCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddFixtureToRoundDayUseCase implements CommandHandler<AddFixtureToRoundDayCommand, Void> {

    private final RoundDayRepository repository;

    @Override
    public Void handle(AddFixtureToRoundDayCommand cmd) {

        RoundDay rd = repository.findById(cmd.roundDayId())
                .orElseThrow(() -> new IllegalArgumentException("RoundDay not found: " + cmd.roundDayId()));

        Fixture f = new Fixture(
                cmd.homeTeamId(),
                cmd.awayTeamId(),
                cmd.homeScore(),
                cmd.awayScore(),
                cmd.date()
        );

        rd.addFixture(f);

        repository.save(rd);

        return null;
    }
}
