package com.app.footballapispring.application.rest.player;

public record PlayerDTO(
        String id,
        String name,
        int age,
        String position,
        String nationality,
        String photo
) {}
