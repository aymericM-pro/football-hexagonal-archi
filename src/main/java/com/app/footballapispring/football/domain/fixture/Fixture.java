package com.app.footballapispring.football.domain.fixture;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Fixture {
    private String id;
    private final String homeTeamId;
    private final String awayTeamId;
    private final Integer homeScore;
    private final Integer awayScore;
    private final LocalDateTime date;

    public Fixture(String id, String homeTeamId, String awayTeamId, Integer homeScore, Integer awayScore, LocalDateTime date) {
        this.id = id;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.date = date;
    }

    public Fixture(String homeTeamId, String awayTeamId, Integer homeScore, Integer awayScore, LocalDateTime date) {
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.date = date;
    }

    public void assignId(String id) {
        if (this.id != null) {
            throw new IllegalStateException("Fixture id already assigned");
        }
        this.id = id;
    }

}
