package com.app.footballapispring.domain.fixture.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.domain.fixture.Fixture;

import java.util.List;

public record GetAllFixturesQuery() implements Query<List<Fixture>> {
}
