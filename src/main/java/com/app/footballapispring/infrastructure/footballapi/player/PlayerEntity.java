package com.app.footballapispring.infrastructure.footballapi.player;

import com.app.footballapispring.infrastructure.footballapi.team.TeamEntity;
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
    private UUID id;

    private String name;
    private int age;
    private String position;
    private String nationality;
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;



    public PlayerEntity(String name, int age, String position, String nationality, String photo) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.photo = photo;
    }
}
