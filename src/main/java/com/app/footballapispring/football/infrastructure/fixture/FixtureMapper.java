package com.app.footballapispring.football.infrastructure.fixture;

import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.infrastructure.roundday.RoundDayEntity;

import java.util.UUID;

public final class FixtureMapper {

    private FixtureMapper() {}

    public static FixtureEntity toEntity(
            Fixture domain,
            RoundDayEntity roundDay
    ) {

        UUID fixtureId = domain.getId() != null
                ? UUID.fromString(domain.getId())
                : UUID.randomUUID();

        domain.assignId(fixtureId.toString());

        FixtureEntity entity = new FixtureEntity();
        entity.setFixtureId(fixtureId);
        entity.setHomeTeamId(domain.getHomeTeamId());
        entity.setAwayTeamId(domain.getAwayTeamId());
        entity.setHomeScore(domain.getHomeScore());
        entity.setAwayScore(domain.getAwayScore());
        entity.setDate(domain.getDate());
        entity.setRoundDay(roundDay);

        return entity;
    }
}
