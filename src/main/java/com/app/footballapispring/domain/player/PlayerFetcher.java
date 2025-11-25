package com.app.footballapispring.domain.player;

import java.io.IOException;
import java.util.List;

public interface PlayerFetcher {

    List<Player> fetchPlayers(int teamId, int season, int page);
}