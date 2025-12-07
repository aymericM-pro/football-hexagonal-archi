package com.app.footballapispring.footballApi.domain.fixtures;

import com.app.footballapispring.domain.player.Player;

import java.util.List;

public interface PlayerFetcher {

    List<Player> fetchPlayers(int teamId, int season, int page);
}