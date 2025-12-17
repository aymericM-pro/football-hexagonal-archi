package com.app.footballapispring.football.domain.fixture.usecases;

import com.app.footballapispring.core.errors.BusinessException;
import com.app.footballapispring.core.errors.exceptions.FixtureError;
import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.fixture.FixtureRepository;
import com.app.footballapispring.football.domain.fixture.commands.GetFixtureByIdQuery;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetFixtureByIdUseCase implements QueryHandler<GetFixtureByIdQuery, Fixture> {

    private final FixtureRepository repository;

    @Override
    public Fixture handle(GetFixtureByIdQuery query) {
        return repository.findById(query.id())
                .orElseThrow(() -> new BusinessException(FixtureError.FIXTURE_NOT_FOUND));
    }
}
