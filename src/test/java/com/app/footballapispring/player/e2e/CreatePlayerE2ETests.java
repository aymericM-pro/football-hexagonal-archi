package com.app.footballapispring.player.e2e;

import com.app.footballapispring.IntegrationTests;
import com.app.footballapispring.football.application.rest.player.CreatePlayerDTO;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.models.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class CreatePlayerE2ETests extends IntegrationTests {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void shouldCreatePlayer() throws Exception {
        var dto = new CreatePlayerDTO(
                "player",
                25,
                Position.ATT,
                "France",
                "url"
        );

        var result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        var json = objectMapper.readTree(result.getResponse().getContentAsString());
        var id = json.get("id").asText();

        assertThat(id)
                .as("Returned ID must not be null or blank")
                .isNotBlank();

        var player = playerRepository.findById(id).orElse(null);

        assertNotNull(player, "Player must exist in repository");

        assertEquals(dto.name(), player.getName(), "Name must match DTO");

        assertThat(player.getNationality())
                .isEqualTo("France");
    }
}
