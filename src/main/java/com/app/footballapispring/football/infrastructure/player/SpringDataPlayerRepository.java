package com.app.footballapispring.football.infrastructure.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPlayerRepository extends JpaRepository<PlayerEntity, UUID> {
}

