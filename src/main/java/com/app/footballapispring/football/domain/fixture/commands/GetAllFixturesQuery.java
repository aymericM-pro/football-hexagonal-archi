package com.app.footballapispring.football.domain.fixture.commands;

import com.app.footballapispring.core.mediator.Query;
import com.app.footballapispring.football.domain.fixture.Fixture;

import java.util.List;

public record GetAllFixturesQuery() implements Query<List<Fixture>> {
}
