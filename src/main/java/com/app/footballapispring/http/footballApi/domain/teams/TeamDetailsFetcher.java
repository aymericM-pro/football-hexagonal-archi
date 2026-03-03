package com.app.footballapispring.http.footballApi.domain.teams;

public interface TeamDetailsFetcher {
    TeamDetail fetchTeamDetails(int teamId);
}
