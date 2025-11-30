package com.app.footballapispring.infrastructure.footballapi.player;

import com.app.footballapispring.domain.player.Player;
import tools.jackson.databind.JsonNode;

public class PlayerInfraFootballMapper {

    public static Player toDomain(JsonNode p) {

        JsonNode playerNode = p.path("player");

        return new Player(
                playerNode.path("id").asString(),
                playerNode.path("name").asText("Unknown"),
                playerNode.path("age").asInt(-1),
                playerNode.path("position").asText("Unknown"),
                playerNode.path("nationality").asText("Unknown"),
                playerNode.path("photo").asText("")
        );
    }
}
