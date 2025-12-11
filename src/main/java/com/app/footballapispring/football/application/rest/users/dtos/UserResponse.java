package com.app.footballapispring.football.application.rest.users.dtos;

public record UserResponse(
        String id,
        String email,
        String role
) {}