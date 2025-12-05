package com.app.footballapispring.application.rest.users.dtos;

public record RegisterRequestDTO(
        String email,
        String password
) {}
