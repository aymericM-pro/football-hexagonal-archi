package com.app.footballapispring.http.footballApi.infrastructure.standings;

import com.app.footballapispring.http.footballApi.rest.FootballApiHttpClient;
import com.app.footballapispring.config.FootballApiProperties;
import com.app.footballapispring.http.footballApi.domain.standings.Standing;
import com.app.footballapispring.http.footballApi.domain.standings.StandingsFetcher;
import okhttp3.HttpUrl;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

@Component
public class StandingsApiAdapter implements StandingsFetcher {

    private final FootballApiHttpClient http;
    private final FootballApiProperties props;

    public StandingsApiAdapter(FootballApiHttpClient http, FootballApiProperties props)  {
        this.http = http;
        this.props = props;
    }

    @Override
    public List<Standing> fetchStandings(int league, int season) {

        HttpUrl url = Objects.requireNonNull(HttpUrl.parse(props.standingsUrl())).newBuilder()
                .addQueryParameter("league", String.valueOf(league))
                .addQueryParameter("season", String.valueOf(season))
                .build();

        JsonNode root = http.get(url.toString(), props.getKey());

        JsonNode items = root
                .path("response").get(0)
                .path("league").path("standings").get(0);

        return StreamSupport.stream(items.spliterator(), false)
                .map(StandingsInfraMapper::toDomain)
                .toList();
    }
}
