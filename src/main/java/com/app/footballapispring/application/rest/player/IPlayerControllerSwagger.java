package com.app.footballapispring.application.rest.player;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPlayerControllerSwagger {

    @Operation(
            summary = "Récupère tous les joueurs",
            description = "Retourne l'intégralité des joueurs stockés dans la base.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Liste récupérée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerDTO.class)
                            )
                    )
            }
    )
    ResponseEntity<List<PlayerDTO>> getAllPlayers();

    @Operation(
            summary = "Récupère un joueur par son ID",
            description = "Retourne les informations d’un joueur.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Joueur trouvé"),
                    @ApiResponse(responseCode = "404", description = "Joueur introuvable")
            }
    )
    ResponseEntity<PlayerDTO> getPlayerById(
            @Parameter(description = "ID du joueur", example = "550e8400-e29b-41d4-a716-446655440000")
            String id
    );


    @Operation(
            summary = "Crée un nouveau joueur",
            description = "Insère un nouveau joueur dans la base.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Joueur créé",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Requête invalide")
            }
    )
    ResponseEntity<PlayerDTO> createPlayer(
            @Parameter(description = "Payload création joueur")
            CreatePlayerDTO dto
    );


    @Operation(
            summary = "Met à jour un joueur",
            description = "Modifie les champs d’un joueur existant.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Joueur mis à jour"),
                    @ApiResponse(responseCode = "404", description = "Joueur introuvable")
            }
    )
    ResponseEntity<PlayerDTO> updatePlayer(
            @Parameter(description = "ID du joueur", example = "550e8400-e29b-41d4-a716-446655440000")
            String id,

            @Parameter(description = "Nouvelles données du joueur")
            PlayerDTO dto
    );


    @Operation(
            summary = "Supprime un joueur",
            description = "Supprime un joueur existant.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Suppression réussie"),
                    @ApiResponse(responseCode = "404", description = "Joueur introuvable")
            }
    )
    ResponseEntity<Void> deletePlayer(
            @Parameter(description = "ID du joueur", example = "550e8400-e29b-41d4-a716-446655440000")
            String id
    );
}
