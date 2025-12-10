package com.app.footballapispring.football.domain.championship;


import java.util.Optional;

public interface ChampionshipRepository {
    Championship save(Championship championship);
    Optional<Championship> findById(String championshipId);
}
