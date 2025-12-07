package com.app.footballapispring.footballApi.domain.fixtures;

import com.app.footballapispring.domain.teams.TeamDetail;

public interface TeamDetailsFetcher {
    TeamDetail fetchTeamDetails(int teamId);
}
