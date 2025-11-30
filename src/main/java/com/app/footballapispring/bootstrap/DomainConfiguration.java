package com.app.footballapispring.bootstrap;

import com.app.footballapispring.domain.fixtures.FixtureFetcher;
import com.app.footballapispring.domain.fixtures.GetFixturesUseCase;
import com.app.footballapispring.domain.player.GetPlayersUseCase;
import com.app.footballapispring.domain.player.PlayerFetcher;
import com.app.footballapispring.domain.player.PlayerRepository;
import com.app.footballapispring.domain.player.usescases.*;
import com.app.footballapispring.domain.standings.GetStandingsUseCase;
import com.app.footballapispring.domain.standings.StandingsFetcher;
import com.app.footballapispring.domain.teams.GetTeamDetailsUseCase;
import com.app.footballapispring.domain.teams.Team;
import com.app.footballapispring.domain.teams.TeamDetailsFetcher;
import com.app.footballapispring.domain.teams.TeamRepository;
import com.app.footballapispring.domain.teams.commands.GetAllTeamsQuery;
import com.app.footballapispring.domain.teams.commands.GetTeamByIdQuery;
import com.app.footballapispring.domain.teams.usescases.AddPlayerToTeamUseCase;
import com.app.footballapispring.domain.teams.usescases.CreateTeamUseCase;
import com.app.footballapispring.domain.teams.usescases.GetAllTeamUseCase;
import com.app.footballapispring.domain.teams.usescases.GetTeamByIdUseCase;
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

    @Bean
    public GetAllPlayersUseCase getAllPlayersHandler(PlayerRepository repo) {
        return new GetAllPlayersUseCase(repo);
    }

    @Bean
    public GetPlayerByIdUseCase getPlayerByIdHandler(PlayerRepository repo) {
        return new GetPlayerByIdUseCase(repo);
    }

    @Bean
    public CreatePlayerUseCase createPlayerUseCase(PlayerRepository repo) {
        return new CreatePlayerUseCase(repo);
    }

    @Bean
    public UpdatePlayerUseCase updatePlayerHandler(PlayerRepository repo) {
        return new UpdatePlayerUseCase(repo);
    }

    @Bean
    public DeletePlayerUseCase deletePlayerHandler(PlayerRepository repo) {
        return new DeletePlayerUseCase(repo);
    }

    @Bean
    public CreateTeamUseCase createTeamUseCase(TeamRepository repo) {
        return new CreateTeamUseCase(repo);
    }

    @Bean
    public GetAllTeamUseCase getAllTeamUseCase(TeamRepository repo) {
        return new GetAllTeamUseCase(repo);
    }

    @Bean
    public AddPlayerToTeamUseCase addPlayerToTeamUseCase(TeamRepository repository, PlayerRepository repo) {
        return new AddPlayerToTeamUseCase(repository, repo);
    }

    @Bean
    public GetTeamByIdUseCase getTeamByIdUseCase(TeamRepository repository) {
        return new GetTeamByIdUseCase(repository);
    }
}
