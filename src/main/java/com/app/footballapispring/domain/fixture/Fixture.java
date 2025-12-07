package com.app.footballapispring.domain.fixture;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Fixture {
    private String id;
    private String homeTeamId;
    private String awayTeamId;
    private Integer homeScore;
    private Integer awayScore;
    private LocalDateTime date;

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
}
