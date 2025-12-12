package com.app.footballapispring.football.infrastructure.roundday;

import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.infrastructure.fixture.FixtureEntity;

public final class RoundDayMapper {

    private RoundDayMapper() {}

    public static RoundDay toDomain(RoundDayEntity entity) {
        RoundDay round = new RoundDay(
                entity.getRoundDayId().toString(),
                entity.getNumber()
        );

        entity.getFixtures().forEach(f ->
                round.addFixture(
                        new Fixture(
                                f.getFixtureId().toString(),
                                f.getHomeTeamId(),
                                f.getAwayTeamId(),
                                f.getHomeScore(),
                                f.getAwayScore(),
                                f.getDate()
                        )
                )
        );

        return round;
    }

    public static RoundDayEntity toEntity(RoundDay domain) {
        RoundDayEntity entity = new RoundDayEntity(domain.getNumber());

        domain.getFixtures().forEach(f ->
                entity.addFixture(
                        new FixtureEntity(
                                f.getHomeTeamId(),
                                f.getAwayTeamId(),
                                f.getHomeScore(),
                                f.getAwayScore(),
                                f.getDate()
                        )
                )
        );

        return entity;
    }
}
