package com.app.footballapispring.teams;

import com.app.footballapispring.football.domain.player.Player;
import com.app.footballapispring.football.domain.player.PlayerRepository;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.TeamRepository;
import com.app.footballapispring.football.domain.teams.commands.AddPlayerToTeamCommand;
import com.app.footballapispring.football.domain.teams.usescases.AddPlayerToTeamUseCase;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AddPlayerToTeamUseCaseTest {

    private final TeamRepository teamRepo = mock(TeamRepository.class);
    private final PlayerRepository playerRepo = mock(PlayerRepository.class);

    private final AddPlayerToTeamUseCase useCase =
            new AddPlayerToTeamUseCase(teamRepo, playerRepo);

    @Test
    void should_add_player_to_team() {

        Team team = new Team("t1", "PSG", "France");
        when(teamRepo.findById("t1")).thenReturn(Optional.of(team));

        Player p = new Player("1", "Mbappé", 25, "FW", "France", "photo");
        when(playerRepo.findById("p1")).thenReturn(Optional.of(p));

        Team updated = new Team("t1", "PSG", "France");
        updated.getPlayers().add(p);

        when(teamRepo.addPlayer(team, p)).thenReturn(updated);

        Team result = useCase.handle(new AddPlayerToTeamCommand("t1", "p1"));

        assertThat(result.getPlayers()).hasSize(1);
        assertThat(result.getPlayers().getFirst().getName()).isEqualTo("Mbappé");

        verify(teamRepo).findById("t1");
        verify(playerRepo).findById("p1");
        verify(teamRepo).addPlayer(team, p);
    }
}
