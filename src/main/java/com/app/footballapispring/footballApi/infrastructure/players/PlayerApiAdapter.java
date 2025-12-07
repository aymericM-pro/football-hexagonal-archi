package com.app.footballapispring.footballApi.infrastructure.players;

import com.app.footballapispring.footballApi.rest.FootballApiHttpClient;
import com.app.footballapispring.config.FootballApiProperties;
import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.footballApi.domain.fixtures.PlayerFetcher;
import okhttp3.HttpUrl;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class PlayerApiAdapter implements PlayerFetcher {

    private final FootballApiHttpClient http;
    private final FootballApiProperties props;

    public PlayerApiAdapter(FootballApiHttpClient http, FootballApiProperties props) {
        this.http = http;
        this.props = props;
    }

    @Override
    public List<Player> fetchPlayers(int teamId, int season, int page) {

        HttpUrl url = HttpUrl.parse(props.getBaseUrl() + "/players").newBuilder()
                .addQueryParameter("team", String.valueOf(teamId))
                .addQueryParameter("season", String.valueOf(season))
                .addQueryParameter("page", String.valueOf(page))
                .build();

        JsonNode items = http.get(url.toString(), props.getKey()).path("response");

        return StreamSupport.stream(items.spliterator(), false)
                .map(PlayerInfraFootballMapper::toDomain)
                .toList();
    }
}
