package com.app.footballapispring.football.infrastructure.championship;


import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.infrastructure.team.TeamInfraMapper;

public final class ChampionshipMapper {

    private ChampionshipMapper() {}

    public static Championship toDomain(ChampionshipEntity entity) {
        if (entity == null) return null;

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

    public static ChampionshipEntity toEntity(Championship domain) {
        if (domain == null) return null;

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
}
