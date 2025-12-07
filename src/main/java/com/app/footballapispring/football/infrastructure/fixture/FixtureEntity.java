package com.app.footballapispring.football.infrastructure.fixture;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "fixtures")
public class FixtureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID fixtureId;

    @Column(nullable = false)
    private String homeTeamId;

    @Column(nullable = false)
    private String awayTeamId;

    private Integer homeScore;
    private Integer awayScore;

    private LocalDateTime date;

    public FixtureEntity(String homeTeamId,
                         String awayTeamId,
                         Integer homeScore,
                         Integer awayScore,
                         LocalDateTime date) {
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.date = date;
    }

}


