package com.app.footballapispring.application.rest.users.dtos;

public record LoginRequestDTO(
        String email,
        String password
) {}