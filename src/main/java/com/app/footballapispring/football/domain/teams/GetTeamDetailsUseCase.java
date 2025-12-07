package com.app.footballapispring.football.domain.teams;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.http.footballApi.domain.fixtures.TeamDetailsFetcher;

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
