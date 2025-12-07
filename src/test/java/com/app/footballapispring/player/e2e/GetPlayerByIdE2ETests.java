package com.app.footballapispring.player.e2e;

import com.app.footballapispring.IntegrationTests;
import com.app.footballapispring.football.application.rest.player.CreatePlayerDTO;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class GetPlayerByIdE2ETests extends IntegrationTests {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void shouldFindPlayerById() throws Exception {

        CreatePlayerDTO dto = new CreatePlayerDTO("PlayerX", 30, "DF", "Germany", "photoX");

        var creation = mockMvc.perform(
                        MockMvcRequestBuilders.post("/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        var createdJson = objectMapper.readTree(creation.getResponse().getContentAsString());
        var id = createdJson.get("id").asText();

        assertThat(id).isNotBlank();

        var playerInDb = playerRepository.findById(id).orElse(null);

        assertNotNull(playerInDb);
        assertEquals("PlayerX", playerInDb.getName());
        assertEquals(30, playerInDb.getAge());
        assertEquals("DF", playerInDb.getPosition());
        assertEquals("Germany", playerInDb.getNationality());

        var result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/players/" + id)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        var json = objectMapper.readTree(result.getResponse().getContentAsString());

        assertEquals("PlayerX", json.get("name").asText());
        assertEquals("Germany", json.get("nationality").asText());
        assertEquals("DF", json.get("position").asText());
        assertEquals(30, json.get("age").asInt());
        assertNotNull(json.get("photo"));
    }
}
