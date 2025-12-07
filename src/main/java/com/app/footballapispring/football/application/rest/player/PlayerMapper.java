package com.app.footballapispring.football.application.rest.player;

import com.app.footballapispring.football.domain.player.Player;

public class PlayerMapper {

    public static PlayerDTO toDto(Player p) {
        return new PlayerDTO(
                p.getId(),
                p.getName(),
                p.getAge(),
                p.getPosition(),
                p.getNationality(),
                p.getPhoto()
        );
    }
}
