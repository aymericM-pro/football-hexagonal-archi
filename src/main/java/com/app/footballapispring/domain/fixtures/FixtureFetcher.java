package com.app.footballapispring.domain.fixtures;

import java.io.IOException;
import java.util.List;

public interface FixtureFetcher {
    List<Fixture> fetchFixtures(int league, int season, int day);
}
