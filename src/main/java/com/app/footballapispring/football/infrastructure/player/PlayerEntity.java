package com.app.footballapispring.football.infrastructure.player;

import com.app.footballapispring.football.domain.player.models.Position;
import com.app.footballapispring.football.infrastructure.team.TeamEntity;
import jakarta.persistence.*;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class PlayerEntity {

    @Id
    @GeneratedValue
    private UUID playerId;

    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Position position;

    private String nationality;
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;



    public PlayerEntity(String name, int age, Position position, String nationality, String photo) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.photo = photo;
    }
}
