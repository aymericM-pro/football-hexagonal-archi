package com.app.footballapispring.football.domain.teams;

import com.app.footballapispring.football.domain.player.Player;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {
    Team save(Team t);
    Optional<Team> findById(String id);
    List<Team> findAll();
    Team addPlayer(Team team, Player player);
    void addTeamToChampionship(String teamId, String championshipId);
}
