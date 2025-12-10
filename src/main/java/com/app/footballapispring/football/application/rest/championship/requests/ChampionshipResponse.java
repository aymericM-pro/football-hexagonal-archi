package com.app.footballapispring.football.application.rest.championship.requests;

import com.app.footballapispring.core.models.Country;
import com.app.footballapispring.football.domain.championship.ChampionshipType;

public record ChampionshipResponse(
        String id,
        String name,
        String code,
        Country country,
        String season,
        String division,
        ChampionshipType type,
        String photo) {
}
