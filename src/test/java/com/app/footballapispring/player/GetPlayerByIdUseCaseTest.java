package com.app.footballapispring.player;


import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.GetPlayerByIdQuery;
import com.app.footballapispring.football.domain.player.usescases.GetPlayerByIdUseCase;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetPlayerByIdUseCaseTest {

    @Test
    void shouldReturnPlayerById() {
        var repo = mock(PlayerRepository.class);
        var useCase = new GetPlayerByIdUseCase(repo);

        var p = new Player("1", "PlayerX", 30, "DF", "Germany", "photo");

        when(repo.findById("1")).thenReturn(Optional.of(p));

        var result = useCase.handle(new GetPlayerByIdQuery("1"));

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("PlayerX");

        verify(repo).findById("1");
    }

    @Test
    void shouldThrowWhenPlayerNotFound() {
        var repo = mock(PlayerRepository.class);
        var useCase = new GetPlayerByIdUseCase(repo);

        when(repo.findById("999")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> useCase.handle(new GetPlayerByIdQuery("999")))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Player not found");

        verify(repo).findById("999");
    }
}
