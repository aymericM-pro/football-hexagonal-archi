package com.app.footballapispring.http.footballApi.infrastructure.players;

import com.app.footballapispring.http.footballApi.domain.players.Player;
import com.fasterxml.jackson.databind.JsonNode;

public class PlayerInfraFootballMapper {

    public static Player toDomain(JsonNode p) {
        JsonNode player = p.path("player");
        JsonNode stats = p.path("statistics").get(0);
        return new Player(
                player.path("id").asText(null),
                player.path("name").asText(null),
                player.path("age").asInt(),
                stats == null ? null : stats.path("games").path("position").asText(null),
                player.path("nationality").asText(null),
                player.path("photo").asText(null)
        );
    }
}
