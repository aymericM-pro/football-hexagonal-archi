package com.app.footballapispring.http.footballApi.infrastructure.standings;

import com.app.footballapispring.http.footballApi.domain.standings.Standing;
import com.fasterxml.jackson.databind.JsonNode;

public class StandingsInfraMapper {

    public static Standing toDomain(JsonNode t) {

        return new Standing(
                t.path("rank").asInt(),
                t.path("team").path("id").asInt(),
                t.path("team").path("name").asText(null),
                t.path("points").asInt(),
                t.path("all").path("played").asInt(),
                t.path("all").path("win").asInt(),
                t.path("all").path("draw").asInt(),
                t.path("all").path("lose").asInt(),
                t.path("all").path("goals").path("for").asInt(),
                t.path("all").path("goals").path("against").asInt(),
                t.path("goalsDiff").asInt()
        );
    }
}
