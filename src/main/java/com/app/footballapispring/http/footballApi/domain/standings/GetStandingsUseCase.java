package com.app.footballapispring.http.footballApi.domain.standings;

import com.app.footballapispring.core.mediator.QueryHandler;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStandingsUseCase
        implements QueryHandler<GetStandingsQuery, List<Standing>> {
    private final StandingsFetcher fetcher;

    public GetStandingsUseCase(StandingsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    @Cacheable(
            value = "standings",
            key = "#root.args[0].league() + '-' + #root.args[0].season()"
    )    public List<Standing> handle(GetStandingsQuery query) {
        return fetcher.fetchStandings(query.league(), query.season());
    }
}