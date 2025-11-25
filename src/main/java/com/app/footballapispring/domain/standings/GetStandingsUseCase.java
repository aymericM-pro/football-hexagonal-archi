package com.app.footballapispring.domain.standings;

import com.app.footballapispring.core.mediator.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

public class GetStandingsUseCase implements QueryHandler<GetStandingsQuery, List<Standing>> {

    private final StandingsFetcher fetcher;

    public GetStandingsUseCase(StandingsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public List<Standing> handle(GetStandingsQuery q) {
        return fetcher.fetchStandings(q.league(), q.season());
    }
}