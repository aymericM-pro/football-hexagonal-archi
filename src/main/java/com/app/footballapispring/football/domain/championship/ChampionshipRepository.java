package com.app.footballapispring.football.domain.championship;


import java.util.List;
import java.util.Optional;

public interface ChampionshipRepository {
    Championship save(Championship championship);
    Optional<Championship> findById(String championshipId);
    List<Championship> findAll();
    Optional<Championship> findByIdWithTeams(String championshipId);
}
