package com.app.footballapispring.http.footballApi.domain.players;

import java.util.List;

public interface PlayerFetcher {
    List<Player> fetchPlayers(int teamId, int season, int page);
}
