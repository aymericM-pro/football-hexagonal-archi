package com.app.footballapispring.football.application.rest.users;

import com.app.footballapispring.football.application.rest.users.dtos.AuthResponseDTO;
import com.app.footballapispring.football.application.rest.users.dtos.LoginRequestDTO;
import com.app.footballapispring.football.application.rest.users.dtos.RegisterRequestDTO;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Tag(name = "Users", description = "Endpoints de gestion des utilisateurs")
public interface IAuthControllerSwagger {

    @Operation(
            summary = "Créer un nouvel utilisateur",
            description = "Enregistre un nouvel utilisateur avec email + mot de passe.",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RegisterRequestDTO.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Utilisateur créé"),
                    @ApiResponse(responseCode = "400", description = "Requête invalide"),
                    @ApiResponse(responseCode = "409", description = "L'utilisateur existe déjà")
            }
    )
    ResponseEntity<AuthResponseDTO> register(
            RegisterRequestDTO dto
    );

    @Operation(
            summary = "Authentifier un utilisateur",
            description = "Retourne un token JWT si l'email et le mot de passe sont corrects.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Connexion réussie",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AuthResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "401", description = "Identifiants incorrects")
            }
    )
    ResponseEntity<AuthResponseDTO> login(
            LoginRequestDTO dto
    );
}
