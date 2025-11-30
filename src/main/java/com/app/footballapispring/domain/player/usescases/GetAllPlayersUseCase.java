package com.app.footballapispring.domain.player.usescases;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.PlayerRepository;
import com.app.footballapispring.domain.player.command.GetAllPlayersQuery;

import java.util.List;

public class GetAllPlayersUseCase implements QueryHandler<GetAllPlayersQuery, List<Player>> {

    private final PlayerRepository repo;

    public GetAllPlayersUseCase(PlayerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Player> handle(GetAllPlayersQuery q) {
        return repo.findAll();
    }
}
