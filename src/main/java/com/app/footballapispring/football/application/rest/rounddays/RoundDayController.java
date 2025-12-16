package com.app.footballapispring.football.application.rest.rounddays;

import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.football.application.rest.rounddays.request.AddFixtureRequest;
import com.app.footballapispring.football.application.rest.rounddays.request.CreateRoundDayRequest;
import com.app.footballapispring.football.domain.championship.command.GetChampionshipCalendarQuery;
import com.app.footballapispring.football.domain.championship.models.ChampionshipCalendarResult;
import com.app.footballapispring.football.domain.roundday.commands.*;
import com.app.footballapispring.football.domain.roundday.models.RoundDayResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rounddays")
public class RoundDayController implements IRoundDayControllerSwagger {

    private final Mediator mediator;

    public RoundDayController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    @PostMapping
    public ResponseEntity<RoundDayResponse> create(
            @RequestBody CreateRoundDayRequest req
    ) {
        RoundDayResult result = mediator.send(
                new CreateRoundDayCommand(
                        req.championshipId(),
                        req.number()
                )
        );

        return ResponseEntity.status(201).body(
                new RoundDayResponse(
                        result.id(),
                        result.number(),
                        java.util.List.of()
                )
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RoundDayResponse> getById(
            @PathVariable String id
    ) {
        RoundDayResult rd = mediator.send(
                new GetRoundDayQuery(id)
        );

        return ResponseEntity.ok(
                new RoundDayResponse(
                        rd.id(),
                        rd.number(),
                        java.util.List.of()
                )
        );
    }

    @Override
    @PostMapping("/{id}/fixtures")
    public ResponseEntity<Void> addFixture(
            @PathVariable String id,
            @RequestBody AddFixtureRequest req
    ) {
        mediator.send(
                new AddFixtureToRoundDayCommand(
                        req.championshipId(),
                        id,
                        req.homeTeamId(),
                        req.awayTeamId(),
                        req.homeScore(),
                        req.awayScore(),
                        req.date()
                )
        );

        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{dayId}/fixtures/{fixtureId}")
    public ResponseEntity<Void> removeFixture(
            @PathVariable String championshipId,
            @PathVariable String dayId,
            @PathVariable String fixtureId
    ) {
        mediator.send(
                new RemoveFixtureFromRoundDayCommand(
                        championshipId,
                        dayId,
                        fixtureId
                )
        );

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/calendar")
    public ResponseEntity<ChampionshipCalendarResult> getCalendar(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(
                mediator.send(new GetChampionshipCalendarQuery(id))
        );
    }
}
