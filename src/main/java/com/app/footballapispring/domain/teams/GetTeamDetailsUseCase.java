package com.app.footballapispring.domain.teams;

import com.app.footballapispring.core.mediator.QueryHandler;

import java.io.IOException;

public class GetTeamDetailsUseCase implements QueryHandler<GetTeamDetailsQuery, TeamDetail> {

    private final TeamDetailsFetcher fetcher;

    public GetTeamDetailsUseCase(TeamDetailsFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public TeamDetail handle(GetTeamDetailsQuery q) {
        return fetcher.fetchTeamDetails(q.id());
    }
}
