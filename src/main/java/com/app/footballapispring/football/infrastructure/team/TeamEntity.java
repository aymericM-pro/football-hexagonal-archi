package com.app.footballapispring.football.infrastructure.team;

import com.app.footballapispring.football.infrastructure.championship.ChampionshipEntity;
import com.app.footballapispring.football.infrastructure.player.PlayerEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
public class TeamEntity {

    @Id
    @GeneratedValue
    private UUID teamId;

    private String name;
    private String country;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "championship_teams",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "championship_id")
    )
    private List<ChampionshipEntity> championships = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<PlayerEntity> players = new ArrayList<>();

    public TeamEntity(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void addChampionship(ChampionshipEntity championship) {
        this.championships.add(championship);
        championship.getTeams().add(this);
    }


    public void addPlayer(PlayerEntity player) {
        players.add(player);
        player.setTeam(this);
    }

    public void removePlayer(PlayerEntity player) {
        players.remove(player);
        player.setTeam(null);
    }
}
