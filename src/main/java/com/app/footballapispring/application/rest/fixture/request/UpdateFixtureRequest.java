package com.app.footballapispring.application.rest.fixture.request;

import java.time.LocalDateTime;

public record UpdateFixtureRequest(
        Integer homeScore,
        Integer awayScore,
        LocalDateTime date
){
}
