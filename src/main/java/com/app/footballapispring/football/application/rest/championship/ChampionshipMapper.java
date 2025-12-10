package com.app.footballapispring.football.application.rest.championship;

import com.app.footballapispring.football.application.rest.championship.requests.ChampionshipResponse;
import com.app.footballapispring.football.domain.championship.Championship;

public class ChampionshipMapper {

    public static ChampionshipResponse toDto(Championship c) {
        return new ChampionshipResponse(
                c.getId(),
                c.getName(),
                c.getCode(),
                c.getCountry(),
                c.getSeason(),
                c.getDivision(),
                c.getType(),
                c.getLogoUrl()
        );
    }
}
