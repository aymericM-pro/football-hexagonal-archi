package com.app.footballapispring.domain.fixture.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.domain.fixture.Fixture;

public record GetFixtureByIdQuery(String id) implements Query<Fixture> {
}
