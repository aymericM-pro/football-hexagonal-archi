package com.app.footballapispring.football.application.rest.player;

import com.app.footballapispring.football.domain.player.models.Position;

public record PlayerDTO(
        String id,
        String name,
        int age,
        Position position,
        String nationality,
        String photo
) {}
