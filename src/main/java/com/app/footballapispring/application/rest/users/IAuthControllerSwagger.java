package com.app.footballapispring.application.rest.users;

import com.app.footballapispring.application.rest.users.dtos.AuthResponseDTO;
import com.app.footballapispring.application.rest.users.dtos.LoginRequestDTO;
import com.app.footballapispring.application.rest.users.dtos.RegisterRequestDTO;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface IAuthControllerSwagger {

    @Operation(
            summary = "Créer un nouvel utilisateur",
            description = "Enregistre un nouvel utilisateur avec email + mot de passe. Le mot de passe est hashé.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Utilisateur créé"),
                    @ApiResponse(responseCode = "400", description = "Requête invalide"),
                    @ApiResponse(responseCode = "409", description = "L'utilisateur existe déjà")
            }
    )
    ResponseEntity<AuthResponseDTO> register(
            @Parameter(description = "Informations d'inscription")
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
            @Parameter(description = "Identifiants de connexion")
            LoginRequestDTO dto
    );
}
