package com.app.footballapispring.http.footballApi.domain.fixtures;

import com.app.footballapispring.core.mediator.QueryHandler;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetFixturesUseCase implements QueryHandler<GetFixturesQuery, List<Fixture>> {

    private final FixtureFetcher fetcher;

    public GetFixturesUseCase(FixtureFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    @Cacheable(
            value = "matches",
            key = "#root.args[0].league() + '-' + #root.args[0].season() + '-' + #root.args[0].day()"
    )    public List<Fixture> handle(GetFixturesQuery q) {
        return fetcher.fetchFixtures(q.league(), q.season(), q.day());
    }
}
