package com.app.footballapispring.domain.fixture;

import java.util.List;
import java.util.Optional;

public interface FixtureRepository {
    List<Fixture> findAllFixtures();
    Fixture save(Fixture fixture);
    Optional<Fixture> findById(String id);
    void delete(String id);
}
