package com.app.footballapispring.football.application.rest.fixture.request;

import java.time.LocalDateTime;

public record UpdateFixtureRequest(
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
){
}
