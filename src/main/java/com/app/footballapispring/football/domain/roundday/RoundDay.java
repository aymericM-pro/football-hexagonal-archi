package com.app.footballapispring.football.domain.roundday;

import com.app.footballapispring.football.domain.fixture.Fixture;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;
import java.util.Objects;

@Getter
public class RoundDay {

    private final String id;
    private final int number;
    private final List<Fixture> fixtures = new ArrayList<>();

    public RoundDay(String id, int number) {
        this.id = id;
        this.number = number;
    }

    public void addFixture(Fixture fixture) {
        Objects.requireNonNull(fixture, "Fixture must not be null");
        fixtures.add(fixture);
    }

    public void removeFixture(String fixtureId) {

        if (fixtureId == null) {
            throw new IllegalArgumentException("fixtureId must not be null");
        }

        Iterator<Fixture> iterator = fixtures.iterator();

        while (iterator.hasNext()) {
            Fixture fixture = iterator.next();

            if (fixture.getId() != null && fixture.getId().equals(fixtureId)) {
                iterator.remove();
                return;
            }
        }

        throw new IllegalStateException(
                "Fixture not found in RoundDay " + id + " with id=" + fixtureId
        );
    }
}
