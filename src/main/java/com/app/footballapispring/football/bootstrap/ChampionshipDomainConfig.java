package com.app.footballapispring.football.bootstrap;

import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.usescases.AddTeamToChampionshipUseCase;
import com.app.footballapispring.football.domain.championship.usescases.CreateChampionshipUseCase;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChampionshipDomainConfig {

    @Bean
    public CreateChampionshipUseCase createChampionshipUseCase(ChampionshipRepository repository) {
        return new CreateChampionshipUseCase(repository);
    }

    @Bean
    public AddTeamToChampionshipUseCase addTeamToChampionshipUseCase(ChampionshipRepository repository, TeamRepository repositoryTeam) {
        return new AddTeamToChampionshipUseCase(repository, repositoryTeam);
    }
}
