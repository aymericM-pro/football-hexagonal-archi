package com.app.footballapispring.football.domain.teams;

import com.app.footballapispring.football.domain.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Team {

    private final String id;
    private final String name;
    private final String country;
    private final List<Player> players;

    public Team(String id, String name, String country, List<Player> players) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.country = Objects.requireNonNull(country);
        this.players = new ArrayList<>(players);
    }

    public Team(String id, String name, String country) {
        this(id, name, country, new ArrayList<>());
    }
}
