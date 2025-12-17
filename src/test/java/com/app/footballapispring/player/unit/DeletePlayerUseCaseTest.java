package com.app.footballapispring.player.unit;

import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.command.DeletePlayerCommand;
import com.app.footballapispring.football.domain.player.usescases.DeletePlayerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class DeletePlayerUseCaseTest {

    private PlayerRepository playerRepository;
    private DeletePlayerUseCase deletePlayerUseCase;

    @BeforeEach
    void setUp() {
        playerRepository = mock(PlayerRepository.class);
        deletePlayerUseCase = new DeletePlayerUseCase(playerRepository);
    }

    @Test
    @DisplayName("Should successfully delete a player by id")
    void shouldDeletePlayerById() {
        // Arrange
        String playerId = "123";
        DeletePlayerCommand command = new DeletePlayerCommand(playerId);

        // Act
        Void result = deletePlayerUseCase.handle(command);

        // Assert
        verify(playerRepository, times(1)).delete(playerId);
        assertNull(result);
    }

    @Test
    @DisplayName("Should call repository delete method with correct id")
    void shouldCallRepositoryDeleteWithCorrectId() {
        // Arrange
        String playerId = "player-456";
        DeletePlayerCommand command = new DeletePlayerCommand(playerId);

        // Act
        deletePlayerUseCase.handle(command);

        // Assert
        verify(playerRepository).delete(playerId);
        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    @DisplayName("Should handle deletion with different player ids")
    void shouldHandleDifferentPlayerIds() {
        // Test with multiple different IDs
        String[] playerIds = {"1", "abc-123", "player-xyz", "999"};

        for (String playerId : playerIds) {
            // Arrange
            PlayerRepository repo = mock(PlayerRepository.class);
            DeletePlayerUseCase useCase = new DeletePlayerUseCase(repo);
            DeletePlayerCommand command = new DeletePlayerCommand(playerId);

            // Act
            useCase.handle(command);

            // Assert
            verify(repo).delete(playerId);
        }
    }

    @Test
    @DisplayName("Should return null after successful deletion")
    void shouldReturnNullAfterDeletion() {
        // Arrange
        DeletePlayerCommand command = new DeletePlayerCommand("123");

        // Act
        Void result = deletePlayerUseCase.handle(command);

        // Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Should not interact with repository methods other than delete")
    void shouldOnlyCallDeleteMethod() {
        String playerId = "test-player";
        DeletePlayerCommand command = new DeletePlayerCommand(playerId);

        deletePlayerUseCase.handle(command);

        verify(playerRepository, times(1)).delete(playerId);
        verify(playerRepository, never()).save(any());
        verify(playerRepository, never()).findById(anyString());
    }
}
