package com.app.footballapispring.football.application.rest.users.dtos;

public record LoginRequestDTO(
        String email,
        String password
) {}