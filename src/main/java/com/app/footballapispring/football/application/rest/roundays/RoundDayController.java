package com.app.footballapispring.football.application.rest.roundays;

import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.football.application.rest.roundays.request.AddFixtureRequest;
import com.app.footballapispring.football.application.rest.roundays.request.CreateRoundDayRequest;
import com.app.footballapispring.football.domain.rounday.commands.*;
import com.app.footballapispring.football.domain.rounday.models.RoundDayResult;
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
    public ResponseEntity<RoundDayResponse> create(@RequestBody CreateRoundDayRequest req) {
        RoundDayResult result = mediator.send(new CreateRoundDayCommand(req.number()));
        return ResponseEntity.status(201).body(
                new RoundDayResponse(result.id(), result.number(), java.util.List.of())
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RoundDayResponse> getById(@PathVariable String id) {
        RoundDayResult rd = mediator.send(new GetRoundDayQuery(id));
        return ResponseEntity.ok(
                new RoundDayResponse(rd.id(), rd.number(), java.util.List.of())
        );
    }

    @Override
    @PostMapping("/{id}/fixtures")
    public ResponseEntity<Void> addFixture(
            @PathVariable String id,
            @RequestBody AddFixtureRequest req
    ) {
        mediator.send(new AddFixtureToRoundDayCommand(
                id,
                req.homeTeamId(),
                req.awayTeamId(),
                req.homeScore(),
                req.awayScore(),
                req.date()
        ));

        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{dayId}/fixtures/{fixtureId}")
    public ResponseEntity<Void> removeFixture(
            @PathVariable String dayId,
            @PathVariable String fixtureId
    ) {
        mediator.send(new RemoveFixtureFromRoundDayCommand(dayId, fixtureId));
        return ResponseEntity.noContent().build();
    }
}
