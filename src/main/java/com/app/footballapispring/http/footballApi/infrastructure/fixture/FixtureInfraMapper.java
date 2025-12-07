package com.app.footballapispring.http.footballApi.infrastructure.fixture;

import com.app.footballapispring.http.footballApi.domain.fixtures.Fixture;
import com.fasterxml.jackson.databind.JsonNode;

public class FixtureInfraMapper {

    public static Fixture toDomain(JsonNode m) {

        JsonNode fixture = m.path("fixture");
        JsonNode teams = m.path("teams");
        JsonNode goals = m.path("goals");

        return new Fixture(
                fixture.path("id").asLong(),
                fixture.path("date").asText(null),
                fixture.path("status").path("long").asText(null),
                teams.path("home").path("name").asText(null),
                goals.path("home").asInt(),
                teams.path("away").path("name").asText(null),
                goals.path("away").asInt()
        );
    }
}
