package com.app.footballapispring.application.rest.player;

public record CreatePlayerDTO(
        String name,
        int age,
        String position,
        String nationality,
        String photo
) {}