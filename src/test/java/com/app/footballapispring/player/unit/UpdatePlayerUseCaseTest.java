package com.app.footballapispring.player.unit;

import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.UpdatePlayerCommand;
import com.app.footballapispring.football.domain.player.models.Position;
import com.app.footballapispring.football.domain.player.usescases.UpdatePlayerUseCase;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdatePlayerUseCaseTest {
    @Test
    void shouldUpdatePlayer() {
        var repo = mock(PlayerRepository.class);
        var useCase = new UpdatePlayerUseCase(repo);

        Player existing = new Player(
                "123",
                "Old Name",
                22,
                Position.DEF,
                "Germany",
                "old-photo"
        );

        when(repo.findById("123")).thenReturn(Optional.of(existing));

        UpdatePlayerCommand command = new UpdatePlayerCommand(
                "123",
                "New Name",
                25,
                Position.MID,
                "France",
                "new-photo"
        );

        Player saved = new Player(
                "123",
                "New Name",
                25,
                Position.MID,
                "France",
                "new-photo"
        );

        when(repo.save(any())).thenReturn(saved);

        Player result = useCase.handle(command);

        assertEquals("New Name", result.getName());
        assertEquals(25, result.getAge());
        assertEquals(Position.MID, result.getPosition());
        assertEquals("France", result.getNationality());
        assertEquals("new-photo", result.getPhoto());

        verify(repo).save(any(Player.class));
    }

    @Test
    void shouldThrowWhenPlayerNotFound() {
        // Arrange
        var repo = mock(PlayerRepository.class);
        var useCase = new UpdatePlayerUseCase(repo);

        when(repo.findById("999")).thenReturn(Optional.empty());

        UpdatePlayerCommand command = new UpdatePlayerCommand(
                "999",
                "Name",
                30,
                Position.ATT,
                "Italy",
                "photo"
        );

        // Act + Assert
        assertThrows(RuntimeException.class, () -> useCase.handle(command));

        verify(repo, never()).save(any());
    }
}
