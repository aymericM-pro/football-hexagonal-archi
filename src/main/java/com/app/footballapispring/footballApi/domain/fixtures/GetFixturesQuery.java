package com.app.footballapispring.footballApi.domain.fixtures;

import com.app.footballapispring.core.mediator.Query;

import java.util.List;

public record GetFixturesQuery(int league, int season, int day)
        implements Query<List<Fixture>> {}

