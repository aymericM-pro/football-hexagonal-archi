package com.app.footballapispring.football.infrastructure.championship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataChampionshipRepository extends JpaRepository<ChampionshipEntity, UUID> {

    @Query("SELECT DISTINCT c FROM ChampionshipEntity c LEFT JOIN FETCH c.teams WHERE c.id = :id")
    Optional<ChampionshipEntity> findByIdWithTeams(@Param("id") UUID id);
}
