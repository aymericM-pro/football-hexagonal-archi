package com.app.footballapispring.infrastructure.footballapi.team;

import com.app.footballapispring.domain.teams.TeamDetail;
import com.fasterxml.jackson.databind.JsonNode;

public class TeamDetailInfraMapper {

    public static TeamDetail toDomain(JsonNode teamNode, JsonNode venueNode, JsonNode coachNode) {
        return new TeamDetail(
                teamNode.path("id").asInt(),
                teamNode.path("name").asText("Unknown"),
                teamNode.path("country").asText("Unknown"),
                teamNode.path("founded").asInt(0),
                teamNode.path("logo").asText(""),

                venueNode.path("name").asText("N/A"),
                venueNode.path("city").asText("N/A"),
                venueNode.path("capacity").asInt(0),
                venueNode.path("image").asText(""),

                coachNode.path("name").asText("Unknown"),
                coachNode.path("nationality").asText("Unknown"),
                coachNode.path("photo").asText("")
        );
    }
}
