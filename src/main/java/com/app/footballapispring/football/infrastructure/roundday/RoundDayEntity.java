package com.app.footballapispring.football.infrastructure.roundday;

import com.app.footballapispring.football.infrastructure.championship.ChampionshipEntity;
import com.app.footballapispring.football.infrastructure.fixture.FixtureEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "round_days")
public class RoundDayEntity {

    @Id
    @GeneratedValue
    private UUID roundDayId;

    @Column(nullable = false)
    private int number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "championship_id", nullable = false)
    private ChampionshipEntity championship;

    @OneToMany(
            mappedBy = "roundDay",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FixtureEntity> fixtures = new ArrayList<>();

    public RoundDayEntity(int number, ChampionshipEntity championship) {
        this.number = number;
        this.championship = championship;
    }

    public void addFixture(FixtureEntity fixture) {
        fixture.setRoundDay(this);
        this.fixtures.add(fixture);
    }
}
