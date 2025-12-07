package com.app.footballapispring.footballApi.domain.standings;

import java.util.List;

public interface StandingsFetcher {
    List<Standing> fetchStandings(int league, int season);
}

