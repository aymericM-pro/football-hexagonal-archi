package com.app.footballapispring.player.e2e;

import com.app.footballapispring.IntegrationTests;
import com.app.footballapispring.football.application.rest.player.CreatePlayerDTO;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.models.Position;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeletePlayerE2ETests extends IntegrationTests {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void shouldDeletePlayer() throws Exception {
        // Arrange: Create a player first
        String playerId = createPlayer(new CreatePlayerDTO(
                "Cristiano Ronaldo",
                39,
                Position.ATT,
                "Portugal",
                "cr7-photo"
        ));

        // Verify player exists before deletion
        assertTrue(playerRepository.findById(playerId).isPresent(),
                "Player should exist before deletion");

        // Act: Delete the player
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/players/" + playerId)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        // Assert: Verify player no longer exists in repository
        assertFalse(playerRepository.findById(playerId).isPresent(),
                "Player should not exist after deletion");
    }

    @Test
    void shouldDeletePlayerAndVerifyItCannotBeRetrieved() throws Exception {
        // Arrange: Create a player
        String playerId = createPlayer(new CreatePlayerDTO(
                "Lionel Messi",
                37,
                Position.ATT,
                "Argentina",
                "messi-photo"
        ));

        // Act: Delete the player
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/players/" + playerId)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        // Assert: Verify the deleted player is not in the list of players
        JsonNode allPlayers = getPlayers();
        for (JsonNode player : allPlayers) {
            String id = player.get("id").asText();
            assertThat(id).isNotEqualTo(playerId);
        }
    }

    @Test
    void shouldDeleteMultiplePlayers() throws Exception {
        // Arrange: Create multiple players
        String player1Id = createPlayer(new CreatePlayerDTO(
                "Player One",
                25,
                Position.MID,
                "France",
                "photo1"
        ));

        String player2Id = createPlayer(new CreatePlayerDTO(
                "Player Two",
                28,
                Position.DEF,
                "Spain",
                "photo2"
        ));

        String player3Id = createPlayer(new CreatePlayerDTO(
                "Player Three",
                30,
                Position.GK,
                "Germany",
                "photo3"
        ));

        // Verify all players exist
        assertTrue(playerRepository.findById(player1Id).isPresent());
        assertTrue(playerRepository.findById(player2Id).isPresent());
        assertTrue(playerRepository.findById(player3Id).isPresent());

        // Act: Delete first and third players
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/players/" + player1Id)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/players/" + player3Id)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        // Assert: Verify deletions
        assertFalse(playerRepository.findById(player1Id).isPresent(),
                "Player 1 should be deleted");
        assertTrue(playerRepository.findById(player2Id).isPresent(),
                "Player 2 should still exist");
        assertFalse(playerRepository.findById(player3Id).isPresent(),
                "Player 3 should be deleted");
    }

    @Test
    void shouldDeletePlayerAndRepositoryCountShouldDecrease() throws Exception {
        // Arrange: Get initial count and create a player
        JsonNode initialPlayers = getPlayers();
        int initialCount = initialPlayers.size();

        String playerId = createPlayer(new CreatePlayerDTO(
                "New Player",
                26,
                Position.MID,
                "Brazil",
                "photo"
        ));

        // Verify count increased
        JsonNode afterCreatePlayers = getPlayers();
        assertThat(afterCreatePlayers.size()).isEqualTo(initialCount + 1);

        // Act: Delete the player
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/players/" + playerId)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        // Assert: Verify count decreased back to initial
        JsonNode finalPlayers = getPlayers();
        assertThat(finalPlayers.size()).isEqualTo(initialCount);
    }

    // Helper methods
    private String createPlayer(CreatePlayerDTO dto) throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        JsonNode json = objectMapper.readTree(result.getResponse().getContentAsString());
        return json.get("id").asText();
    }

    private JsonNode getPlayers() throws Exception {
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/players")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        return objectMapper.readTree(result.getResponse().getContentAsString());
    }
}
