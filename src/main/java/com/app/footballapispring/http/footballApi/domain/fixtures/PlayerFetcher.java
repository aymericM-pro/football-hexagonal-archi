package com.app.footballapispring.http.footballApi.domain.fixtures;

import com.app.footballapispring.football.domain.player.Player;

import java.util.List;

public interface PlayerFetcher {

    List<Player> fetchPlayers(int teamId, int season, int page);
}