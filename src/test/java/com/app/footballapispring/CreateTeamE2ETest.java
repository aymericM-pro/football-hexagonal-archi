package com.app.footballapispring;

import com.app.footballapispring.application.rest.teams.CreateTeamDTO;
import com.app.footballapispring.application.rest.teams.TeamDTO;
import com.app.footballapispring.domain.teams.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateTeamE2ETest extends IntegrationTests {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void shouldCreateTeam() throws Exception {

        var dto = new CreateTeamDTO("PSG", "France");

        var result = mockMvc.perform(
                        post("/teams")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andReturn();

        var response = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                TeamDTO.class
        );

        clearDatabaseCache();

        var team = teamRepository.findById(response.id()).orElseThrow();

        assertThat(team.getName()).isEqualTo("PSG");
        assertThat(team.getCountry()).isEqualTo("France");
    }
}
