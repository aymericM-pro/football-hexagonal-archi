package com.app.footballapispring.application.rest.fixture.request;

import com.app.footballapispring.domain.fixture.Fixture;

public class FixtureMapper {

    public static FixtureResponse toDto(Fixture f) {
        return new FixtureResponse(
                f.getId(),
                f.getHomeTeamId(),
                f.getAwayTeamId(),
                f.getHomeScore(),
                f.getAwayScore(),
                f.getDate()
        );
    }
}

