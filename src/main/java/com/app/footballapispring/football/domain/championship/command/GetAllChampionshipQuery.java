package com.app.footballapispring.football.domain.championship.command;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllChampionshipQuery implements QueryHandler<GetAllChampionshipsQuery, List<Championship>> {

    public final ChampionshipRepository repository;

    @Override
    public List<Championship> handle(GetAllChampionshipsQuery command) {
        return repository.findAll();
    }
}
