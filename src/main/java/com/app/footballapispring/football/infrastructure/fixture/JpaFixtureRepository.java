package com.app.footballapispring.football.infrastructure.fixture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaFixtureRepository extends JpaRepository<FixtureEntity,  UUID> {

}
