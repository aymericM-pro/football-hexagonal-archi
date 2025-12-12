package com.app.footballapispring.football.bootstrap;

import com.app.footballapispring.football.domain.fixture.FixtureRepository;
import com.app.footballapispring.football.domain.fixture.useCases.CreateFixtureUseCases;
import com.app.footballapispring.football.domain.fixture.useCases.GetAllFixturesUseCase;
import com.app.footballapispring.football.domain.fixture.useCases.GetFixtureByIdUseCase;
import com.app.footballapispring.football.domain.fixture.useCases.UpdateFixtureUseCases;
import com.app.footballapispring.football.domain.teams.commands.GetAllTeamsQuery;
import com.app.footballapispring.http.footballApi.domain.fixtures.FixtureFetcher;
import com.app.footballapispring.http.footballApi.domain.fixtures.GetFixturesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FixturesDomainConfig {

    @Bean
    public GetFixturesUseCase getFixturesUseCase(FixtureFetcher fetcher) {
        return new GetFixturesUseCase(fetcher);
    }

    @Bean
    public GetAllFixturesUseCase getAllFixturesUseCase(FixtureRepository repository) {
        return new GetAllFixturesUseCase(repository);
    }

    @Bean
    public CreateFixtureUseCases createFixtureUseCases(FixtureRepository repository) {
        return new CreateFixtureUseCases(repository);
    }

    @Bean
    public GetFixtureByIdUseCase getFixtureByIdUseCase(FixtureRepository repository) {
        return new GetFixtureByIdUseCase(repository);
    }

    @Bean
    public UpdateFixtureUseCases updateFixtureUseCases(FixtureRepository repository) {
        return new UpdateFixtureUseCases(repository);
    }
}
