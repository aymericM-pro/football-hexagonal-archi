package com.app.footballapispring.footballApi.domain.fixtures;

import java.util.List;

public interface FixtureFetcher {
    List<Fixture> fetchFixtures(int league, int season, int day);
}
