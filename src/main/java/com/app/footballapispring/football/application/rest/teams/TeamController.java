package com.app.footballapispring.football.application.rest.teams;

import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.football.domain.teams.Team;
import com.app.footballapispring.football.domain.teams.commands.AddPlayerToTeamCommand;
import com.app.footballapispring.football.domain.teams.commands.CreateTeamCommand;
import com.app.footballapispring.football.domain.teams.commands.GetAllTeamsQuery;
import com.app.footballapispring.football.domain.teams.commands.GetTeamByIdQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController implements ITeamControllerSwagger {

    private final Mediator mediator;

    public TeamController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return mediator.send(new GetAllTeamsQuery())
                .stream()
                .map(TeamMapper::toDto)
                .toList();
    }

    @Override
    @PostMapping
    public TeamDTO createTeam(@RequestBody CreateTeamDTO dto) {
        Team team = mediator.send(new CreateTeamCommand(
                dto.name(),
                dto.country()
        ));

        return TeamMapper.toDto(team);
    }

    @Override
    @PostMapping("/{teamId}/players/{playerId}")
    public TeamDTO addPlayerToTeam(
            @PathVariable String teamId,
            @PathVariable String playerId
    ) {
        Team updatedTeam = mediator.send(new AddPlayerToTeamCommand(teamId, playerId));
        return TeamMapper.toDto(updatedTeam);
    }

    @Override
    @GetMapping("/{teamId}")
    public TeamInfoDTO getTeamById(@PathVariable String teamId) {
        Team team = mediator.send(new GetTeamByIdQuery(teamId));
        return TeamInfoMapper.toDto(team);
    }
}
