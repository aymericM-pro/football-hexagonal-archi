package com.app.footballapispring.http.footballApi.domain.players;

import com.app.footballapispring.core.mediator.QueryHandler;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Component
public class GetPlayersUseCase implements QueryHandler<GetPlayersQuery, List<Player>> {

    private final PlayerFetcher fetcher;

    public GetPlayersUseCase(PlayerFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    @Cacheable(
            value = "players",
            key = "#root.args[0].team() + '-' + #root.args[0].season() + '-' + #root.args[0].page()"
    )
    public List<Player> handle(GetPlayersQuery query) {
        return fetcher.fetchPlayers(query.team(), query.season(), query.page());
    }
}
