package com.app.footballapispring.football.infrastructure.player;

import com.app.footballapispring.football.domain.player.Player;

public class PlayerInfraMapper {

    public static PlayerEntity toEntity(Player p) {
        return new PlayerEntity(
                p.getName(),
                p.getAge(),
                p.getPosition(),
                p.getNationality(),
                p.getPhoto()
        );
    }

    public static Player toDomain(PlayerEntity e) {
        return new Player(
                e.getPlayerId().toString(),
                e.getName(),
                e.getAge(),
                e.getPosition(),
                e.getNationality(),
                e.getPhoto()
        );
    }
}
