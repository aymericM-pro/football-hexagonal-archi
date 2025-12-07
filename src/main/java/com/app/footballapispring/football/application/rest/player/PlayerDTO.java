package com.app.footballapispring.football.application.rest.player;

public record PlayerDTO(
        String id,
        String name,
        int age,
        String position,
        String nationality,
        String photo
) {}
