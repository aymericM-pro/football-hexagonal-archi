package com.app.footballapispring.football.infrastructure.rounday;

import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.rounday.RoundDay;
import com.app.footballapispring.football.infrastructure.fixture.FixtureEntity;

public final class RoundDayMapper {

    private RoundDayMapper() {}

    public static RoundDay toDomain(RoundDayEntity entity) {
        if (entity == null) return null;

        RoundDay round = new RoundDay(entity.getNumber());

        entity.getFixtures().forEach(f ->
                round.addFixture(
                        new Fixture(
                                f.getRoundDay() != null ? f.getRoundDay().toString() : null,
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
        if (domain == null) return null;

        RoundDayEntity entity = new RoundDayEntity(domain.getNumber());

        domain.getFixtures().forEach(f -> {
            FixtureEntity fe = new FixtureEntity(
                    f.getHomeTeamId(),
                    f.getAwayTeamId(),
                    f.getHomeScore(),
                    f.getAwayScore(),
                    f.getDate()
            );
            entity.addFixture(fe);
        });

        return entity;
    }
}
