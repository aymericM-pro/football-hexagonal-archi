package com.app.footballapispring.http.footballApi.domain.players;

public record Player(
        String id,
        String name,
        int age,
        String position,
        String nationality,
        String photo
) {}
