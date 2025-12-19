package com.app.footballapispring.football.domain.player.usescases;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.GetAllPlayersQuery;
import org.springframework.data.domain.Page;

import java.util.List;

public class GetAllPlayersUseCase
        implements QueryHandler<GetAllPlayersQuery, Page<Player>> {

    private final PlayerRepository repo;

    public GetAllPlayersUseCase(PlayerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Page<Player> handle(GetAllPlayersQuery query) {
        return repo.findAll(query.pageable());
    }
}
