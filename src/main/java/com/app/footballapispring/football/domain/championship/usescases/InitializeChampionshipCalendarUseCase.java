package com.app.footballapispring.football.domain.championship.usescases;

import com.app.footballapispring.core.errors.BusinessException;
import com.app.footballapispring.core.errors.exceptions.ChampionshipsError;
import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.command.InitializeChampionshipCalendarCommand;

public class InitializeChampionshipCalendarUseCase
        implements CommandHandler<InitializeChampionshipCalendarCommand, Championship> {

    private final ChampionshipRepository championshipRepository;

    public InitializeChampionshipCalendarUseCase(
            ChampionshipRepository championshipRepository
    ) {
        this.championshipRepository = championshipRepository;
    }

    @Override
    public Championship handle(InitializeChampionshipCalendarCommand cmd) {

        Championship championship = championshipRepository
                .findById(cmd.championshipId())
                .orElseThrow(() ->
                        new BusinessException(
                                ChampionshipsError.CHAMPIONSHIP_NOT_FOUND
                        )
                );

        championship.createRounddaysChampionship();

        return championshipRepository.save(championship);
    }
}
