package com.app.footballapispring.football.bootstrap;

import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.usescases.*;
import com.app.footballapispring.football.domain.championship.usescases.GetChampionshipCalendarUseCase;
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

    @Bean
    public GetAllChampionshipsUseCase getAllChampionshipQuery(ChampionshipRepository repository) {
        return new GetAllChampionshipsUseCase(repository);
    }

    @Bean
    public InitializeChampionshipCalendarUseCase initializeChampionshipCalendarUseCase(ChampionshipRepository repository) {
        return new InitializeChampionshipCalendarUseCase(repository);
    }

    @Bean
    public GetTeamsOfChampionshipUseCase getTeamsOfChampionshipUseCases(ChampionshipRepository repository) {
        return new GetTeamsOfChampionshipUseCase(repository);
    }

    @Bean
    public GetChampionshipCalendarUseCase getChampionshipCalendarUseCase(ChampionshipRepository repository) {
        return new GetChampionshipCalendarUseCase(repository);
    }

}
