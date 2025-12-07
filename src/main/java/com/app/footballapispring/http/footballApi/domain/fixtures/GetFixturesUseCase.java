package com.app.footballapispring.http.footballApi.domain.fixtures;

import com.app.footballapispring.core.mediator.QueryHandler;

import java.util.List;

public class GetFixturesUseCase implements QueryHandler<GetFixturesQuery, List<Fixture>> {

    private final FixtureFetcher fetcher;

    public GetFixturesUseCase(FixtureFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public List<Fixture> handle(GetFixturesQuery q) {
        return fetcher.fetchFixtures(q.league(), q.season(), q.day());
    }
}
