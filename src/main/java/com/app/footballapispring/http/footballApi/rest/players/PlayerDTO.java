package com.app.footballapispring.http.footballApi.rest.players;

public record PlayerDTO(
        String id,
        String name,
        int age,
        String position,
        String nationality,
        String photo
) {}
