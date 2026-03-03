package com.app.footballapispring.http.footballApi.infrastructure.teams;

import com.app.footballapispring.http.footballApi.domain.teams.TeamDetail;
import com.fasterxml.jackson.databind.JsonNode;

public class TeamDetailInfraMapper {

    public static TeamDetail toDomain(JsonNode team, JsonNode venue, JsonNode coach) {
        return new TeamDetail(
                team.path("id").asInt(),
                team.path("name").asText(null),
                team.path("country").asText(null),
                team.path("founded").asInt(),
                team.path("logo").asText(null),
                venue.path("name").asText(null),
                venue.path("city").asText(null),
                venue.path("capacity").asInt(),
                venue.path("image").asText(null),
                coach.path("name").asText(null),
                coach.path("nationality").asText(null),
                coach.path("photo").asText(null)
        );
    }
}
