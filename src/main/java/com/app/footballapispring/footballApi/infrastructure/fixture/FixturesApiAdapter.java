package com.app.footballapispring.footballApi.infrastructure.fixture;

import com.app.footballapispring.footballApi.rest.OkHttp3Helper;
import com.app.footballapispring.footballApi.domain.fixtures.Fixture;
import com.app.footballapispring.footballApi.domain.fixtures.FixtureFetcher;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

import java.util.Map;
import java.util.stream.StreamSupport;

@Component
public class FixturesApiAdapter implements FixtureFetcher {

    private final OkHttp3Helper helper;

    public FixturesApiAdapter(OkHttp3Helper helper) {
        this.helper = helper;
    }

    @Override
    public List<Fixture> fetchFixtures(int league, int season, int day) {

        String round = "Regular Season - " + day;

        JsonNode items = helper.get("/fixtures", Map.of(
                "league", String.valueOf(league),
                "season", String.valueOf(season),
                "round", round
        ));

        return StreamSupport.stream(items.spliterator(), false)
                .map(FixtureInfraMapper::toDomain)
                .toList();
    }
}

