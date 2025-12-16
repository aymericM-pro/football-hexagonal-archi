package com.app.footballapispring.football.infrastructure.roundday;

import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.infrastructure.championship.ChampionshipEntity;
import com.app.footballapispring.football.infrastructure.fixture.FixtureEntity;
import com.app.footballapispring.football.infrastructure.fixture.FixtureMapper;

import java.util.UUID;

public final class RoundDayMapper {

    private RoundDayMapper() {}

    public static RoundDayEntity toEntity(
            RoundDay domain,
            ChampionshipEntity championship
    ) {

        RoundDayEntity entity = new RoundDayEntity(
                domain.getNumber(),
                championship
        );

        // 🔑 mapping fixtures
        domain.getFixtures().forEach(fixture -> {
            FixtureEntity fixtureEntity =
                    FixtureMapper.toEntity(fixture, entity);
            entity.addFixture(fixtureEntity);
        });

        return entity;
    }

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
}
