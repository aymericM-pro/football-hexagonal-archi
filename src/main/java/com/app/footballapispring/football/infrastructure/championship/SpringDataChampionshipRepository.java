package com.app.footballapispring.football.infrastructure.championship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataChampionshipRepository extends JpaRepository<ChampionshipEntity, UUID> {

    @Query("Select c from ChampionshipEntity c left join fetch c.teams t where c.id = :id")
    Optional<ChampionshipEntity> findByIdWithTeams(@Param("id") String id);
}
