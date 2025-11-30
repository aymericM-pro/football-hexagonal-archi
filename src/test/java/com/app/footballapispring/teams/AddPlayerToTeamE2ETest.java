package com.app.footballapispring.teams;

import com.app.footballapispring.IntegrationTests;
import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.PlayerRepository;
import com.app.footballapispring.domain.teams.Team;
import com.app.footballapispring.domain.teams.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AddPlayerToTeamE2ETest extends IntegrationTests {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    private Team team;
    private Player player;

    @BeforeEach
    void setUp() {
        team = new Team(null, "PSG", "France");
        team = teamRepository.save(team);

        player = new Player(
                "Mbappé",
                25,
                "FW",
                "France",
                "photo"
        );
        player = playerRepository.save(player);
    }

    @Test
    void shouldAddPlayerToTeam() throws Exception {

        // 1️⃣ Appel E2E du vrai endpoint
        mockMvc.perform(
                        post("/teams/" + team.getId() + "/players/" + player.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());

        Team reloaded = teamRepository.findById(team.getId()).orElseThrow();

        // 3️⃣ Vérifications
        assertThat(reloaded.getPlayers()).hasSize(1);
        assertThat(reloaded.getPlayers().getFirst().getName()).isEqualTo("Mbappé");
    }
}
