package com.app.footballapispring.football.application.rest.rounddays;

import com.app.footballapispring.football.application.rest.fixture.request.FixtureResponse;

import java.util.List;

public record RoundDayResponse(
        String id,
        int number,
        List<FixtureResponse> fixtures
) {}
