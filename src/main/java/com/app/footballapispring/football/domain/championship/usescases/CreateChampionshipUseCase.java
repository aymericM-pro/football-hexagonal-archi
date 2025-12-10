package com.app.footballapispring.football.domain.championship.usescases;

import com.app.footballapispring.core.mediator.CommandHandler;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.command.CreateChampionshipCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateChampionshipUseCase implements CommandHandler<com.app.footballapispring.football.domain.championship.command.CreateChampionshipCommand, Championship> {

    public final ChampionshipRepository repo;

    @Override
    public Championship handle(CreateChampionshipCommand command) {
        Championship championship = new Championship(
                command.name(),
                command.code(),
                command.country(),
                command.season(),
                command.division(),
                command.type(),
                command.logoUrl()
        );

        return repo.save(championship);
    }
}
