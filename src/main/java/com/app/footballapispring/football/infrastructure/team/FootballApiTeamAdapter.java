package com.app.footballapispring.football.infrastructure.team;

import com.app.footballapispring.http.footballApi.rest.OkHttp3Helper;
import com.app.footballapispring.football.domain.teams.TeamDetail;
import com.app.footballapispring.http.footballApi.domain.fixtures.TeamDetailsFetcher;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

@Component
public class FootballApiTeamAdapter implements TeamDetailsFetcher {

    private final OkHttp3Helper helper;

    public FootballApiTeamAdapter(OkHttp3Helper helper) {
        this.helper = helper;
    }

    @Override
    public TeamDetail fetchTeamDetails(int teamId) {

        // ==== TEAM + VENUE ====
        JsonNode teamResponse = helper.get("/teams", Map.of(
                "id", String.valueOf(teamId)
        ));

        JsonNode teamNode = teamResponse.get(0).path("team");
        JsonNode venueNode = teamResponse.get(0).path("venue");

        // ==== COACH ====
        JsonNode coachResponse = helper.get("/coachs", Map.of(
                "team", String.valueOf(teamId)
        ));

        JsonNode coachNode = coachResponse.get(0);

        // === Mapping domain ===
        return TeamDetailInfraMapper.toDomain(teamNode, venueNode, coachNode);
    }
}
