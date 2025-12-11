package com.app.footballapispring.football.domain.rounday.useCases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.rounday.RoundDay;
import com.app.footballapispring.football.domain.rounday.RoundDayRepository;
import com.app.footballapispring.football.domain.rounday.commands.CreateRoundDayCommand;
import com.app.footballapispring.football.domain.rounday.models.RoundDayResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateRoundDayUseCase implements CommandHandler<CreateRoundDayCommand, RoundDayResult> {

    private final RoundDayRepository repository;

    @Override
    public RoundDayResult handle(CreateRoundDayCommand cmd) {

        RoundDay day = new RoundDay(cmd.number());

        RoundDay saved = repository.save(day);

        return new RoundDayResult(
                saved.getId(),
                saved.getNumber()
        );
    }
}
