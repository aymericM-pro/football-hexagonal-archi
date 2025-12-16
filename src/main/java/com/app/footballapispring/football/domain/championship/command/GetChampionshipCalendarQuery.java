package com.app.footballapispring.football.domain.championship.command;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.championship.models.ChampionshipCalendarResult;

public record GetChampionshipCalendarQuery(
        String championshipId
) implements Query<ChampionshipCalendarResult> {}