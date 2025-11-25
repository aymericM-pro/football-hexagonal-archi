package com.app.footballapispring.bootstrap;

import com.app.footballapispring.domain.fixtures.FixtureFetcher;
import com.app.footballapispring.domain.fixtures.GetFixturesUseCase;
import com.app.footballapispring.domain.player.GetPlayersUseCase;
import com.app.footballapispring.domain.player.PlayerFetcher;
import com.app.footballapispring.domain.standings.GetStandingsUseCase;
import com.app.footballapispring.domain.standings.StandingsFetcher;
import com.app.footballapispring.domain.teams.GetTeamDetailsUseCase;
import com.app.footballapispring.domain.teams.TeamDetailsFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public GetStandingsUseCase getStandingsUseCase(StandingsFetcher fetcher) {
        return new GetStandingsUseCase(fetcher);
    }

    @Bean
    public GetFixturesUseCase getFixturesUseCase(FixtureFetcher fetcher) {
        return new GetFixturesUseCase(fetcher);
    }

    @Bean
    public GetPlayersUseCase getPlayersUseCase(PlayerFetcher fetcher) {
        return new GetPlayersUseCase(fetcher);
    }

    @Bean
    public GetTeamDetailsUseCase getTeamDetailsUseCase(TeamDetailsFetcher fetcher) {
        return new GetTeamDetailsUseCase(fetcher);
    }
}
