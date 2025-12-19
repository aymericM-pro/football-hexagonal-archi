package com.app.footballapispring.football.bootstrap;

import com.app.footballapispring.football.domain.player.GetPlayersUseCase;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.usescases.*;
import com.app.footballapispring.http.footballApi.domain.fixtures.PlayerFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerDomainConfig {

    @Bean
    public GetPlayersUseCase getPlayersUseCase(PlayerFetcher fetcher) {
        return new GetPlayersUseCase(fetcher);
    }

    @Bean
    public GetAllPlayersUseCase getAllPlayersUseCase(PlayerRepository repo) {
        return new GetAllPlayersUseCase(repo);
    }

    @Bean
    public GetPlayerByIdUseCase getPlayerByIdUseCase(PlayerRepository repo) {
        return new GetPlayerByIdUseCase(repo);
    }

    @Bean
    public CreatePlayerUseCase createPlayerUseCase(PlayerRepository repo) {
        return new CreatePlayerUseCase(repo);
    }

    @Bean
    public UpdatePlayerUseCase updatePlayerUseCase(PlayerRepository repo) {
        return new UpdatePlayerUseCase(repo);
    }

    @Bean
    public DeletePlayerUseCase deletePlayerUseCase(PlayerRepository repo) {
        return new DeletePlayerUseCase(repo);
    }
}
