package com.app.footballapispring.player.unit;

import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.CreatePlayerCommand;
import com.app.footballapispring.football.domain.player.models.Position;
import com.app.footballapispring.football.domain.player.usescases.CreatePlayerUseCase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class CreatePlayerUseCaseTest {

    @Test
    void shouldCreateAPlayer() {
        var repo = mock(PlayerRepository.class);
        var useCase = new CreatePlayerUseCase(repo);

        // Arrange : valeur retournée par le mock
        var saved = new Player(
                "1",
                "Mbappe",
                20,
                Position.MID,
                "France",
                "urlA"
        );

        when(repo.save(any())).thenReturn(saved);

        var result = useCase.handle(new CreatePlayerCommand(
                "Mbappe",
                20,
                Position.MID,
                "France",
                "urlA"
        ));

        verify(repo, times(1)).save(any());
        assertEquals("Mbappe", result.getName());
        assertEquals(Position.MID, result.getPosition());
    }
}
