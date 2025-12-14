package com.app.footballapispring.football.domain.championship.usescases;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.command.GetAllChampionshipsQuery;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllChampionshipsUseCase
        implements QueryHandler<GetAllChampionshipsQuery, List<Championship>> {

    private final ChampionshipRepository repository;

    @Override
    public List<Championship> handle(GetAllChampionshipsQuery query) {
        return repository.findAll();
    }
}
