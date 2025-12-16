package com.app.footballapispring.football.infrastructure.championship;

import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.infrastructure.fixture.FixtureEntity;
import com.app.footballapispring.football.infrastructure.roundday.RoundDayEntity;
import com.app.footballapispring.football.infrastructure.roundday.RoundDayMapper;
import com.app.footballapispring.football.infrastructure.team.TeamInfraMapper;

public final class ChampionshipMapper {

    private ChampionshipMapper() {}

    public static void applyRoundDays(
            Championship domain,
            ChampionshipEntity entity
    ) {
        entity.getRoundDays().clear();

        domain.getRoundDays().forEach(rd -> {

            RoundDayEntity rdEntity = new RoundDayEntity(
                    rd.getNumber(),
                    entity
            );

            rd.getFixtures().forEach(f -> {
                FixtureEntity fixtureEntity = new FixtureEntity(
                        f.getHomeTeamId(),
                        f.getAwayTeamId(),
                        f.getHomeScore(),
                        f.getAwayScore(),
                        f.getDate(),
                        rdEntity
                );
                rdEntity.getFixtures().add(fixtureEntity);
            });

            entity.getRoundDays().add(rdEntity);
        });
    }

    public static ChampionshipEntity toEntity(Championship domain) {
        if (domain == null) {
            return null;
        }

        return new ChampionshipEntity(
                domain.getName(),
                domain.getCode(),
                domain.getCountry(),
                domain.getSeason(),
                domain.getDivision(),
                domain.getType(),
                domain.getLogoUrl()
        );
    }

    public static Championship toDomain(ChampionshipEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Championship(
                entity.getId().toString(),
                entity.getName(),
                entity.getCode(),
                entity.getCountry(),
                entity.getSeason(),
                entity.getDivision(),
                entity.getType(),
                entity.getPhoto()
        );
    }

    public static Championship toDomainWithTeams(ChampionshipEntity entity) {
        Championship championship = toDomain(entity);

        if (entity.getTeams() != null && !entity.getTeams().isEmpty()) {
            championship.setTeams(
                    entity.getTeams()
                            .stream()
                            .map(TeamInfraMapper::toDomain)
                            .toList()
            );
        }

        return championship;
    }

    public static Championship toDomainWithCalendar(ChampionshipEntity entity) {

        Championship championship = toDomainWithTeams(entity);

        entity.getRoundDays().forEach(rd -> {
            RoundDay roundDay = RoundDayMapper.toDomain(rd);
            championship.getRoundDays().add(roundDay);
        });

        return championship;
    }

    public static Championship toDomainWithRoundDays(ChampionshipEntity entity) {

        Championship championship = new Championship(
                entity.getId().toString(),
                entity.getName(),
                entity.getCode(),
                entity.getCountry(),
                entity.getSeason(),
                entity.getDivision(),
                entity.getType(),
                entity.getPhoto()
        );

        entity.getRoundDays().forEach(rd -> {
            RoundDay roundDay = RoundDayMapper.toDomain(rd);

            championship.getRoundDays().add(roundDay);
        });

        return championship;
    }
}
