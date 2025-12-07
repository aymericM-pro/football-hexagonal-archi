package com.app.footballapispring.football.domain.fixture.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.fixture.Fixture;

public record GetFixtureByIdQuery(String id) implements Query<Fixture> {
}
