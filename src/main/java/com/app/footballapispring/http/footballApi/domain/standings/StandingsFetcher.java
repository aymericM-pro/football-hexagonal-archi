package com.app.footballapispring.http.footballApi.domain.standings;

import java.util.List;

public interface StandingsFetcher {
    List<Standing> fetchStandings(int league, int season);
}

