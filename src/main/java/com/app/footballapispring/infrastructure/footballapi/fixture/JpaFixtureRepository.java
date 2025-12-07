package com.app.footballapispring.infrastructure.footballapi.fixture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaFixtureRepository extends JpaRepository<FixtureEntity,  UUID> {

}
