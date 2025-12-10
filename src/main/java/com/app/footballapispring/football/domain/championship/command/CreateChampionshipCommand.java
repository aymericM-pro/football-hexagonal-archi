package com.app.footballapispring.football.domain.championship.command;

import com.app.footballapispring.core.mediator.Command;
import com.app.footballapispring.core.models.Country;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipType;

public record CreateChampionshipCommand(
        String name,
        String code,
        Country country,
        String season,
        String division,
        ChampionshipType type,
        String logoUrl) implements Command<Championship> {
}
