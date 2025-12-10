package com.app.footballapispring.football.infrastructure.championship;


import com.app.footballapispring.football.domain.championship.Championship;

public class ChampionshipMapper {

    public static ChampionshipEntity toEntity(Championship c) {
        return new ChampionshipEntity(
                c.getName(),
                c.getCode(),
                c.getCountry(),
                c.getSeason(),
                c.getDivision(),
                c.getType(),
                c.getLogoUrl()
        );
    }

    public static Championship toDomain(ChampionshipEntity e) {
        return new Championship(
                e.getId().toString(),
                e.getName(),
                e.getCode(),
                e.getCountry(),
                e.getSeason(),
                e.getDivision(),
                e.getType(),
                e.getPhoto()
        );
    }
}
