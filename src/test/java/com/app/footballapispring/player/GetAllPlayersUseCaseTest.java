package com.app.footballapispring.player;

import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.PlayerRepository;
import com.app.footballapispring.domain.player.command.GetAllPlayersQuery;
import com.app.footballapispring.domain.player.usescases.GetAllPlayersUseCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GetAllPlayersUseCaseTest {

    @Test
    void shouldReturnAllPlayers() {
        var repo = mock(PlayerRepository.class);
        var useCase = new GetAllPlayersUseCase(repo);

        var players = List.of(
                new Player("1", "PlayerA", 20, "MF", "France", "urlA"),
                new Player("2", "PlayerB", 25, "FW", "Spain", "urlB")
        );

        when(repo.findAll()).thenReturn(players);
        var result = useCase.handle(new GetAllPlayersQuery());

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("PlayerA");

        verify(repo, times(1)).findAll();
    }
}
