package com.app.footballapispring.http.footballApi.infrastructure.players;

import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.models.Position;
import com.fasterxml.jackson.databind.JsonNode;


public class PlayerInfraFootballMapper {

    public static Player toDomain(JsonNode p) {

        JsonNode playerNode = p.path("player");

        String rawPosition = playerNode.path("position").asText("Unknown");

        Position position = Position.fromApiValue(rawPosition);

        return new Player(
                playerNode.path("id").asText(),
                playerNode.path("name").asText("Unknown"),
                playerNode.path("age").asInt(-1),
                position,
                playerNode.path("nationality").asText("Unknown"),
                playerNode.path("photo").asText("")
        );
    }
}
