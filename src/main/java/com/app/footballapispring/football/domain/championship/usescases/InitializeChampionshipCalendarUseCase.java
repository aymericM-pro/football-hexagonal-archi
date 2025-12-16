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

        if (championshipRepository.findById(cmd.championshipId()).isEmpty()) {
            throw new BusinessException(
                    ChampionshipsError.CHAMPIONSHIP_NOT_FOUND
            );
        }

        return championshipRepository.initializeCalendar(cmd.championshipId());
    }
}
