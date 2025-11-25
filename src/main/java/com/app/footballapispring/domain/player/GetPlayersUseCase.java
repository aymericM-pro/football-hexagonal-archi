package com.app.footballapispring.domain.player;

import com.app.footballapispring.core.mediator.QueryHandler;

import java.util.List;

public class GetPlayersUseCase implements QueryHandler<GetPlayersQuery, List<Player>> {

    private final PlayerFetcher fetcher;

    public GetPlayersUseCase(PlayerFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public List<Player> handle(GetPlayersQuery q) {
        return fetcher.fetchPlayers(q.teamId(), q.season(), q.page());
    }
}
