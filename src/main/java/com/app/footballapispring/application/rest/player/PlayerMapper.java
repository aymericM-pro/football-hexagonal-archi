package com.app.footballapispring.application.rest.player;

import com.app.footballapispring.domain.player.Player;

public class PlayerMapper {

    public static PlayerDTO toDto(Player p) {
        return new PlayerDTO(
                p.id(),
                p.name(),
                p.age(),
                p.position(),
                p.nationality(),
                p.photo()
        );
    }
}
