package com.app.footballapispring.domain.fixture.useCases;

import com.app.footballapispring.core.mediator.QueryHandler;
import com.app.footballapispring.domain.fixture.Fixture;
import com.app.footballapispring.domain.fixture.FixtureRepository;
import com.app.footballapispring.domain.fixture.commands.GetAllFixturesQuery;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllFixturesUseCase implements QueryHandler<GetAllFixturesQuery, List<Fixture>> {

    private final FixtureRepository repository;

    @Override
    public List<Fixture> handle(GetAllFixturesQuery query) {
        return repository.findAllFixtures();
    }
}
