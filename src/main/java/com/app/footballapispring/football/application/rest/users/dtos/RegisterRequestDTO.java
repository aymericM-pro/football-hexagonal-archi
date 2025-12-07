package com.app.footballapispring.football.application.rest.users.dtos;

public record RegisterRequestDTO(
        String email,
        String password
) {}
