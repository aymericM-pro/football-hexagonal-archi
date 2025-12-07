package com.app.footballapispring.football.application.rest.fixture.request;


import com.app.footballapispring.core.mediator.Mediator;
import com.app.footballapispring.football.domain.fixture.Fixture;
import com.app.footballapispring.football.domain.fixture.commands.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fixtures")
public class FixtureController implements IFixtureControllerSwagger {

    private final Mediator mediator;

    public FixtureController(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<FixtureResponse>> getAllFixtures() {
        List<Fixture> fixtures = mediator.send(new GetAllFixturesQuery());
        return ResponseEntity.ok(
                fixtures.stream().map(FixtureMapper::toDto).toList()
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FixtureResponse> getFixtureById(@PathVariable String id) {
        Fixture f = mediator.send(new GetFixtureByIdQuery(id));
        return ResponseEntity.ok(FixtureMapper.toDto(f));
    }

    @Override
    @PostMapping
    public ResponseEntity<FixtureResponse> createFixture(@RequestBody CreateFixtureRequest req) {
        Fixture created = mediator.send(new CreateFixtureCommand(
                req.homeTeamId(),
                req.awayTeamId(),
                req.homeScore(),
                req.awayScore(),
                req.date()
        ));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(FixtureMapper.toDto(created));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<FixtureResponse> updateFixture(
            @PathVariable String id,
            @RequestBody UpdateFixtureRequest req
    ) {
        Fixture updated = mediator.send(new UpdateFixtureCommand(
                id,
                req.homeScore(),
                req.awayScore(),
                req.date()
        ));

        return ResponseEntity.ok(FixtureMapper.toDto(updated));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFixture(@PathVariable String id) {
        mediator.send(new DeleteFixtureCommand(id));
        return ResponseEntity.noContent().build();
    }
}

