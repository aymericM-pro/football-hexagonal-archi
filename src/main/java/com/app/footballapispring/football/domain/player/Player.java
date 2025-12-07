package com.app.footballapispring.football.domain.player;

import com.app.footballapispring.football.domain.player.models.Position;
import lombok.Getter;

@Getter
public class Player {

    private String id;
    private final String name;
    private final int age;
    private final Position position;
    private final String nationality;
    private final String photo;

    public Player(String id, String name, int age, Position position, String nationality, String photo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.photo = photo;
    }

    public Player(String name, int age, Position position, String nationality, String photo) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.photo = photo;
    }
}
