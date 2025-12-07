package com.app.footballapispring.player.e2e;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.app.footballapispring.IntegrationTests;
import com.app.footballapispring.football.application.rest.player.CreatePlayerDTO;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.player.models.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.JsonNode;

class GetPlayersE2ETests extends IntegrationTests {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void shouldFindAllPlayers() throws Exception {

        createPlayer(new CreatePlayerDTO("PlayerA", 22, Position.MID, "France", "photoA"));
        createPlayer(new CreatePlayerDTO("PlayerB", 28, Position.DEF, "Spain", "photoB"));

        var json = getPlayers();

        assertThat(json.isArray()).isTrue();
        assertThat(json.size()).isEqualTo(2);


        assertPlayer(json.get(0), "PlayerA", "France");
        assertPlayer(json.get(1), "PlayerB", "Spain");
    }

    private void createPlayer(CreatePlayerDTO dto) throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
        ).andExpect(MockMvcResultMatchers.status().isCreated());
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

    private void assertPlayer(JsonNode node, String expectedName, String expectedNationality) {
        assertNotNull(node.get("id"));
        assertEquals(expectedName, node.get("name").asText());
        assertEquals(expectedNationality, node.get("nationality").asText());
    }
}
