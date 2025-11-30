package com.app.footballapispring.infrastructure.footballapi.player;

import com.app.footballapispring.domain.player.Player;

public final class PlayerInfraMapper {

    private PlayerInfraMapper() {}

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
                e.getId().toString(),
                e.getName(),
                e.getAge(),
                e.getPosition(),
                e.getNationality(),
                e.getPhoto()
        );
    }
}
