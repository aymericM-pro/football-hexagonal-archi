package com.app.footballapispring.footballApi.domain.standings;

import com.app.footballapispring.core.mediator.Query;

import java.util.List;

public record GetStandingsQuery(int league, int season)
        implements Query<List<Standing>> {}
