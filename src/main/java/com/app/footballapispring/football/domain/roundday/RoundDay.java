package com.app.footballapispring.football.domain.roundday;

import com.app.footballapispring.football.domain.fixture.Fixture;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RoundDay {

    private String id;
    private final int number;
    private final List<Fixture> fixtures = new ArrayList<>();

    public RoundDay(int number) {
        this.number = number;
    }

    public RoundDay(String id, int number) {
        this.id = id;
        this.number = number;
    }


    public void addFixture(Fixture fixture) {
        boolean exists = fixtures.stream()
                .anyMatch(f -> f.getId().equals(fixture.getId()));

        if (exists) {
            throw new IllegalStateException("Fixture already exists in round " + number);
        }

        fixtures.add(fixture);
    }

    public void removeFixture(String fixtureId) {
        fixtures.removeIf(f -> f.getId().equals(fixtureId));
    }
}
