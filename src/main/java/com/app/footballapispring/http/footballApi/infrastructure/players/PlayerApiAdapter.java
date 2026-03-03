package com.app.footballapispring.http.footballApi.infrastructure.players;

import com.app.footballapispring.http.footballApi.rest.FootballApiClient;
import com.app.footballapispring.http.footballApi.domain.players.Player;
import com.app.footballapispring.http.footballApi.domain.players.PlayerFetcher;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@Component
public class PlayerApiAdapter implements PlayerFetcher {

    private final FootballApiClient helper;

    public PlayerApiAdapter(FootballApiClient helper) {
        this.helper = helper;
    }

    @Override
    public List<Player> fetchPlayers(int teamId, int season, int page) {
        JsonNode items = helper.get("/players", Map.of(
                "team", String.valueOf(teamId),
                "season", String.valueOf(season),
                "page", String.valueOf(page)
        ));

        return StreamSupport.stream(items.spliterator(), false)
                .map(PlayerInfraFootballMapper::toDomain)
                .toList();
    }
}
