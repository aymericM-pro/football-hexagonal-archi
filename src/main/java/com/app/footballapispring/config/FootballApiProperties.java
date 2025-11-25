package com.app.footballapispring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "football.api")
public class FootballApiProperties {

    private String key;
    private String baseUrl;

    // --- GETTERS / SETTERS ---
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static final String STANDINGS_PATH = "/standings";
    public static final String FIXTURES_PATH  = "/fixtures";
    public static final String PLAYERS_PATH   = "/players";

    public String standingsUrl() {
        return baseUrl + STANDINGS_PATH;
    }

    public String fixturesUrl() {
        return baseUrl + FIXTURES_PATH;
    }

    public String playersUrl() {
        return baseUrl + PLAYERS_PATH;
    }
}
