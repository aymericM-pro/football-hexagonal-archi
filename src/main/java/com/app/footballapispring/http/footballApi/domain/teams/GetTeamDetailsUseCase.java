package com.app.footballapispring.http.footballApi.domain.teams;

import com.app.footballapispring.core.mediator.QueryHandler;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class GetTeamDetailsUseCase implements QueryHandler<GetTeamDetailsQuery, TeamDetail> {

    private final TeamDetailsFetcher fetcher;

    public GetTeamDetailsUseCase(TeamDetailsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    @Cacheable(
            value = "teamDetails",
            key = "#root.args[0].id()"
    )
    public TeamDetail handle(GetTeamDetailsQuery query) {
        return fetcher.fetchTeamDetails(query.id());
    }
}
