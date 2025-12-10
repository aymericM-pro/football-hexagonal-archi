package com.app.footballapispring.championship.e2e;

import com.app.footballapispring.IntegrationTests;
import com.app.footballapispring.core.models.Country;
import com.app.footballapispring.football.application.rest.championship.requests.CreateChampionshipRequest;
import com.app.footballapispring.football.application.rest.championship.requests.ChampionshipResponse;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.domain.championship.ChampionshipType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateChampionshipE2ETest extends IntegrationTests {

    private CreateChampionshipRequest request;

    @BeforeEach
    void setup() {
        request = new CreateChampionshipRequest(
                "Premier League",
                "EPL",
                Country.GB,
                "2024/2025",
                "D1",
                ChampionshipType.LEAGUE,
                "https://example.com/epl.png"
        );
    }

    @Test
    void shouldAddChampionship() throws Exception {

        var result = mockMvc
                .perform(
                        post("/championships")
                                 .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isCreated())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        var response = objectMapper.readValue(json, ChampionshipResponse.class);

        assertThat(response.id()).isNotNull();
        assertThat(response.name()).isEqualTo("Premier League");
        assertThat(response.code()).isEqualTo("EPL");
        assertThat(response.country()).isEqualTo(Country.GB);
        assertThat(response.season()).isEqualTo("2024/2025");
        assertThat(response.division()).isEqualTo("D1");
        assertThat(response.type()).isEqualTo(ChampionshipType.LEAGUE);
        assertThat(response.photo()).isEqualTo("https://example.com/epl.png");
    }
}
