package com.app.footballapispring.http.footballApi.rest.fixture;

import com.app.footballapispring.http.footballApi.domain.fixtures.Fixture;

public class FixtureMapper {

    public static FixtureDTO toDto(Fixture f) {
        return new FixtureDTO(
                f.id(),
                f.date(),
                f.status(),
                f.homeTeam(),
                f.homeGoals(),
                f.awayTeam(),
                f.awayGoals()
        );
    }
}
