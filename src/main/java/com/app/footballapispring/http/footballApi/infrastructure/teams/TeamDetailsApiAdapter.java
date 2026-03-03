package com.app.footballapispring.http.footballApi.infrastructure.teams;

import com.app.footballapispring.http.footballApi.domain.teams.TeamDetail;
import com.app.footballapispring.http.footballApi.domain.teams.TeamDetailsFetcher;
import com.app.footballapispring.http.footballApi.rest.FootballApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TeamDetailsApiAdapter implements TeamDetailsFetcher {

    private final FootballApiClient helper;

    public TeamDetailsApiAdapter(FootballApiClient helper) {
        this.helper = helper;
    }

    @Override
    public TeamDetail fetchTeamDetails(int teamId) {
        JsonNode teamResponse = helper.get("/teams", Map.of("id", String.valueOf(teamId)));
        JsonNode teamNode = teamResponse.get(0).path("team");
        JsonNode venueNode = teamResponse.get(0).path("venue");

        JsonNode coachResponse = helper.get("/coachs", Map.of("team", String.valueOf(teamId)));
        JsonNode coachNode = coachResponse.get(0);

        return TeamDetailInfraMapper.toDomain(teamNode, venueNode, coachNode);
    }
}
