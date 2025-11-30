package com.app.footballapispring.domain.standings;

import java.util.List;

public interface StandingsFetcher {
    List<Standing> fetchStandings(int league, int season);
}

