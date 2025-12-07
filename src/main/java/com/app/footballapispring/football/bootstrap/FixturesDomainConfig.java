package com.app.footballapispring.football.bootstrap;

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
}
