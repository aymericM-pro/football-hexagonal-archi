package com.app.footballapispring.football.bootstrap;

import com.app.footballapispring.http.footballApi.domain.standings.GetStandingsUseCase;
import com.app.footballapispring.http.footballApi.domain.standings.StandingsFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StandingsDomainConfig {

    @Bean
    public GetStandingsUseCase getStandingsUseCase(StandingsFetcher fetcher) {
        return new GetStandingsUseCase(fetcher);
    }
}
