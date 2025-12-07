package com.app.footballapispring.football.bootstrap;

import com.app.footballapispring.football.domain.teams.TeamRepository;
import com.app.footballapispring.football.domain.teams.usescases.*;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamDomainConfig {

    @Bean
    public CreateTeamUseCase createTeamUseCase(TeamRepository repo) {
        return new CreateTeamUseCase(repo);
    }

    @Bean
    public GetAllTeamUseCase getAllTeamUseCase(TeamRepository repo) {
        return new GetAllTeamUseCase(repo);
    }

    @Bean
    public GetTeamByIdUseCase getTeamByIdUseCase(TeamRepository repo) {
        return new GetTeamByIdUseCase(repo);
    }

    @Bean
    public AddPlayerToTeamUseCase addPlayerToTeamUseCase(
            TeamRepository teamRepo,
            PlayerRepository playerRepo
    ) {
        return new AddPlayerToTeamUseCase(teamRepo, playerRepo);
    }
}
