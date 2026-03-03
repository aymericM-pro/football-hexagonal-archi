package com.app.footballapispring.http.footballApi.rest.players;

import com.app.footballapispring.http.footballApi.domain.players.Player;

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
