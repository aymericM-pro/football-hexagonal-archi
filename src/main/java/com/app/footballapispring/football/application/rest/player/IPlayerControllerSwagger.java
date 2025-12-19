package com.app.footballapispring.football.application.rest.player;

import com.app.footballapispring.core.base.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.app.footballapispring.core.base.PageResponse;

@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Players", description = "Endpoints de gestion des joueurs")
public interface IPlayerControllerSwagger {

    @Operation(
            summary = "Récupère les joueurs (paginé par défaut)",
            description = """
                Retourne la liste des joueurs avec pagination activée par défaut.
                
                Paramètres par défaut :
                - page = 0
                - size = 20
                - sort = name,asc
                """,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Page de joueurs récupérée",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = PageResponse.class
                                    )
                            )
                    )
            }
    )
    ResponseEntity<BaseResponse<PageResponse<PlayerDTO>>> getAllPlayers(
            @ParameterObject Pageable pageable
    );

    @Operation(
            summary = "Récupère un joueur par son ID",
            description = "Retourne les informations détaillées d'un joueur.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Joueur trouvé",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Joueur introuvable")
            }
    )
    ResponseEntity<BaseResponse<PlayerDTO>> getPlayerById(
            @Parameter(
                    description = "ID du joueur",
                    example = "550e8400-e29b-41d4-a716-446655440000"
            )
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
    ResponseEntity<BaseResponse<PlayerDTO>> createPlayer(
            @Parameter(description = "Payload de création du joueur")
            CreatePlayerDTO dto
    );

    @Operation(
            summary = "Met à jour un joueur",
            description = "Modifie les champs d'un joueur existant.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Joueur mis à jour",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Joueur introuvable")
            }
    )
    ResponseEntity<BaseResponse<PlayerDTO>> updatePlayer(
            @Parameter(
                    description = "ID du joueur",
                    example = "550e8400-e29b-41d4-a716-446655440000"
            )
            String id,
            @Parameter(description = "Nouvelles données du joueur")
            PlayerDTO dto
    );

    @Operation(
            summary = "Supprime un joueur",
            description = "Supprime définitivement un joueur.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Suppression réussie"),
                    @ApiResponse(responseCode = "404", description = "Joueur introuvable")
            }
    )
    ResponseEntity<Void> deletePlayer(
            @Parameter(
                    description = "ID du joueur",
                    example = "550e8400-e29b-41d4-a716-446655440000"
            )
            String id
    );
}
