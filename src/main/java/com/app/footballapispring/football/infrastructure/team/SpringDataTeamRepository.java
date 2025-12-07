package com.app.footballapispring.football.infrastructure.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataTeamRepository extends JpaRepository<TeamEntity, UUID> {

    @Query("SELECT t FROM TeamEntity t LEFT JOIN FETCH t.players WHERE t.id = :id")
    Optional<TeamEntity> findByIdWithPlayers(UUID id);
}
