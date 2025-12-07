package com.app.footballapispring.football.application.rest.player;

public record CreatePlayerDTO(
        String name,
        int age,
        String position,
        String nationality,
        String photo
) {}