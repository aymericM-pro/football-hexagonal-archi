package com.app.footballapispring.football.application.rest.player;

import com.app.footballapispring.football.domain.player.models.Position;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePlayerDTO(

        @NotBlank(message = "Le nom est obligatoire")
        @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
        String name,

        @Min(value = 18, message = "Un joueur doit avoir au moins 5 ans")
        @Max(value = 40, message = "Un joueur ne peut pas dépasser 60 ans")
        int age,

        @NotBlank(message = "La position est obligatoire")
        Position position,

        @NotBlank(message = "La nationalité est obligatoire")
        String nationality,

        @Size(max = 255, message = "L’URL de la photo ne peut dépasser 255 caractères")
        String photo
) {}
