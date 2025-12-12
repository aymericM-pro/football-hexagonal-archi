package com.app.footballapispring.football.infrastructure.roundday;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataRoundDayRepository extends JpaRepository<RoundDayEntity, UUID> {
}

