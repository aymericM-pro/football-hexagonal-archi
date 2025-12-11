package com.app.footballapispring.football.application.rest.users.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public record RegisterRequestDTO(

        @Schema(description = "Adresse email", example = "john.doe@example.com")
        String email,

        @Schema(description = "Mot de passe", example = "Password123!")
        String password

) {}
