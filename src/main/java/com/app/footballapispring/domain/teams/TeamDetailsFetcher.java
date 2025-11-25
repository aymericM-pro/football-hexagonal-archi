package com.app.footballapispring.domain.teams;

import java.io.IOException;

public interface TeamDetailsFetcher {
    TeamDetail fetchTeamDetails(int teamId);
}
