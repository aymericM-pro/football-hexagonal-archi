package com.app.footballapispring.http.footballApi.domain.fixtures;

import com.app.footballapispring.football.domain.teams.TeamDetail;

public interface TeamDetailsFetcher {
    TeamDetail fetchTeamDetails(int teamId);
}
