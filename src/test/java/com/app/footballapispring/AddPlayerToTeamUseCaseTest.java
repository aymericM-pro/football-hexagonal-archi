package com.app.footballapispring;

import com.app.footballapispring.domain.player.Player;
import com.app.footballapispring.domain.player.PlayerRepository;
import com.app.footballapispring.domain.teams.Team;
import com.app.footballapispring.domain.teams.TeamRepository;
import com.app.footballapispring.domain.teams.commands.AddPlayerToTeamCommand;
import com.app.footballapispring.domain.teams.usescases.AddPlayerToTeamUseCase;
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
        Player p = new Player("1", "Mbappé", 25, "FW", "France", "photo");
        when(playerRepo.findById("p1")).thenReturn(Optional.of(p));

        Team t = new Team("t1", "PSG", "France");
        when(teamRepo.addPlayer("t1", p)).thenReturn(t);

        Team result = useCase.handle(new AddPlayerToTeamCommand("t1", "p1"));

        assertThat(result).isSameAs(t);
        verify(playerRepo).findById("p1");
        verify(teamRepo).addPlayer("t1", p);
    }
}
