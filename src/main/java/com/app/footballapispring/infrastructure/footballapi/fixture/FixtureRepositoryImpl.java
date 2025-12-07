package com.app.footballapispring.infrastructure.footballapi.fixture;

import com.app.footballapispring.domain.fixture.Fixture;
import com.app.footballapispring.domain.fixture.FixtureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class FixtureRepositoryImpl implements FixtureRepository {

    private final JpaFixtureRepository jpa;

    @Override
    public List<Fixture> findAllFixtures() {
        return jpa.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Fixture save(Fixture f) {

        FixtureEntity entity = new FixtureEntity(
                f.getHomeTeamId(),
                f.getAwayTeamId(),
                f.getHomeScore(),
                f.getAwayScore(),
                f.getDate()
        );

        FixtureEntity saved = jpa.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<Fixture> findById(String id) {
        return jpa.findById(UUID.fromString(id))
                .map(this::toDomain);
    }

    @Override
    public void delete(String id) {
        jpa.deleteById(UUID.fromString(id));
    }

    private Fixture toDomain(FixtureEntity e) {
        return new Fixture(
                e.getFixtureId().toString(),
                e.getHomeTeamId(),
                e.getAwayTeamId(),
                e.getHomeScore(),
                e.getAwayScore(),
                e.getDate()
        );
    }
}
