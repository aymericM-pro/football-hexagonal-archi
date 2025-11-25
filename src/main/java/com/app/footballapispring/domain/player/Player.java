package com.app.footballapispring.domain.player;

public record Player(
        long id,
        String name,
        int age,
        String position,
        String nationality,
        String photo
) {}