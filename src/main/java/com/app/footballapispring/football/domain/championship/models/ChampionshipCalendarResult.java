package com.app.footballapispring.football.domain.championship.models;

import com.app.footballapispring.football.domain.fixture.models.FixtureResult;

import java.util.List;
import java.util.Map;

public record ChampionshipCalendarResult(
        Map<Integer, List<FixtureResult>> calendar
) {}