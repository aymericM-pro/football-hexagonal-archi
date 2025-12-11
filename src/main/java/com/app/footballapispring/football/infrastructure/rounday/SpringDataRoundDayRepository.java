package com.app.footballapispring.football.infrastructure.rounday;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataRoundDayRepository extends JpaRepository<RoundDayEntity, UUID> {
}

