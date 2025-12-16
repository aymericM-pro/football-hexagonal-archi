package com.app.footballapispring.football.infrastructure.championship;

import com.app.footballapispring.core.models.Country;
import com.app.footballapispring.football.domain.championship.ChampionshipType;
import com.app.footballapispring.football.infrastructure.roundday.RoundDayEntity;
import com.app.footballapispring.football.infrastructure.team.TeamEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "championship")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampionshipEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String code;
    private Country country;
    private String season;
    private String division;
    private ChampionshipType type;
    private String photo;

    @ManyToMany(mappedBy = "championships", fetch = FetchType.LAZY)
    private List<TeamEntity> teams = new ArrayList<>();

    @OneToMany(
            mappedBy = "championship",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RoundDayEntity> roundDays = new ArrayList<>();

    public ChampionshipEntity(String name,
                              String code,
                              Country country,
                              String season,
                              String division,
                              ChampionshipType type,
                              String photo) {
        this.name = name;
        this.code = code;
        this.country = country;
        this.season = season;
        this.division = division;
        this.type = type;
        this.photo = photo;
    }
}
