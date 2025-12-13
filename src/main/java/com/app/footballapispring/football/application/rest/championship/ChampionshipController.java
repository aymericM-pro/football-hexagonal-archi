package com.app.footballapispring.football.application.rest.championship;

import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.football.application.rest.championship.requests.ChampionshipResponse;
import com.app.footballapispring.football.application.rest.championship.requests.CreateChampionshipRequest;
import com.app.footballapispring.football.application.rest.teams.TeamMapper;
import com.app.footballapispring.football.application.rest.teams.TeamResponse;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.command.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/championships")
public class ChampionshipController implements IChampionshipSwagger {

    private final Mediator mediator;

    public ChampionshipController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ChampionshipResponse> createChampionship(@RequestBody CreateChampionshipRequest dto) {

        var championship = mediator.send(new CreateChampionshipCommand(
                dto.name(),
                dto.code(),
                dto.country(),
                dto.season(),
                dto.division(),
                dto.type(),
                dto.photo()
        ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ChampionshipMapper.toDto(championship));
    }

    @PostMapping("/{championshipId}/teams/{teamId}")
    @Override
    public ResponseEntity<ChampionshipResponse> addTeamToChampionship(
            @PathVariable String championshipId,
            @PathVariable String teamId) {

        var championship = mediator.send(
               new AddTeamToChampionshipCommand(championshipId, teamId)
        );

        return ResponseEntity.ok(
                ChampionshipMapper.toDto(championship)
        );
    }

    @GetMapping
    public ResponseEntity<List<ChampionshipResponse>> getAllChampionships() {

        List<ChampionshipResponse> result = mediator.send(new GetAllChampionshipsQuery())
                .stream()
                .map(ChampionshipMapper::toDto)
                .toList();

        return ResponseEntity.ok(result);
    }

    @PostMapping("/{championshipId}/initialize")
    public ResponseEntity<Championship> initializeCalendar(
            @PathVariable String championshipId
    ) {
        Championship championship = mediator.send(
                new InitializeChampionshipCalendarCommand(championshipId)
        );

        return ResponseEntity.ok(championship);
    }

    @GetMapping("/{championshipId}/teams")
    public ResponseEntity<List<TeamResponse>> getTeamsOfChampionship(
            @PathVariable String championshipId
    ) {
        List<TeamResponse> teams = mediator.send(
                        new GetTeamsOfChampionshipQuery(championshipId)
                ).stream()
                .map(TeamMapper::toResponse)
                .toList();

        return ResponseEntity.ok(teams);
    }
}
