package com.app.footballapispring.football.domain.roundday.usecases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.domain.roundday.RoundDayRepository;
import com.app.footballapispring.football.domain.roundday.commands.CreateRoundDayCommand;
import com.app.footballapispring.football.domain.roundday.models.RoundDayResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateRoundDayUseCase
        implements CommandHandler<CreateRoundDayCommand, RoundDayResult> {

    private final RoundDayRepository repository;

    @Override
    public RoundDayResult handle(CreateRoundDayCommand cmd) {

        RoundDay roundDay = new RoundDay(
                null,
                cmd.number()
        );

        RoundDay saved = repository.save(
                roundDay,
                cmd.championshipId()
        );

        return new RoundDayResult(
                saved.getId(),
                saved.getNumber()
        );
    }
}