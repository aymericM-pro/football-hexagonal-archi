package com.app.footballapispring.domain.standings;

import com.app.footballapispring.core.mediator.QueryHandler;

import java.util.List;

public class GetStandingsUseCase implements QueryHandler<GetStandingsQuery, List<Standing>> {

    private final StandingsFetcher fetcher;

    public GetStandingsUseCase(StandingsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public List<Standing> handle(GetStandingsQuery query) {
        return fetcher.fetchStandings(query.league(), query.season());
    }
}