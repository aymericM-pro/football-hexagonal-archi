package com.app.footballapispring.football.domain.player.usescases;

import com.app.footballapispring.core.errors.BusinessException;
import com.app.footballapispring.core.errors.exceptions.PlayerError;
import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.GetPlayerByIdQuery;

public class GetPlayerByIdUseCase implements QueryHandler<GetPlayerByIdQuery, Player> {

    private final PlayerRepository repo;

    public GetPlayerByIdUseCase(PlayerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Player handle(GetPlayerByIdQuery q) {
        return repo.findById(q.id())
                .orElseThrow(() -> new BusinessException(PlayerError.PLAYER_NOT_FOUND));
    }
}
